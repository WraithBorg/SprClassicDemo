package com.spr.controller;

import com.spr.entity.OrderBill;
import com.spr.eum.OrderBillOperator;
import com.spr.event.OrderBillEvent;
import com.spr.event.OrderBillEventDto;
import com.spr.result.DockResult;
import com.spr.service.ins.OrderBillService;
import com.spr.util.BusinessException;
import com.spr.util.SprLock;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;

/**
 * 订单控制器
 */
@Controller
public class OrderBillController {
    private static final Logger LOGGER = LoggerFactory.getLogger(OrderBillController.class);
    @Resource
    private OrderBillService orderBillService;
    @Resource
    private ApplicationContext applicationContext;

    /**
     * 创建订单 unsafe
     */
    @GetMapping("/createBill")
    @ResponseBody
    public DockResult createBill(String code) {
        DockResult<OrderBill> dockResult = orderBillService.createBill(OrderBill.builder(code));
        if (dockResult.success()) {
            OrderBillEventDto billEventDto = OrderBillEventDto.builder(OrderBillOperator.CREATE, dockResult.getData());
            OrderBillEvent orderBillEvent = new OrderBillEvent(billEventDto);
            applicationContext.publishEvent(orderBillEvent);
        }
        return dockResult;
    }

    /**
     * 创建订单 safe
     */
    @GetMapping("/createBill4Safe")
    @ResponseBody
    public DockResult createBill4Safe4Get(String code) {
        try (SprLock lock = new SprLock("zx", code)) {
            if (code.equals("001")) {
                try {
                    Thread.sleep(5000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            return orderBillService.createBill(OrderBill.builder(code));
        } catch (BusinessException e) {
            return DockResult.fail("创建订单失败{}", e.getMessage());
        } catch (Exception e) {
            LOGGER.error("创建订单失败：", e);
            return DockResult.fail("创建订单失败,请联系管理员");
        }
    }

}
