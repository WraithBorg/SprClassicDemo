package com.spr.controller;

import com.spr.event.OrderBillEvent;
import com.spr.event.OrderBillEventDto;
import com.spr.entity.OrderBill;
import com.spr.eum.OrderBillOperator;
import com.spr.result.DockResult;
import com.spr.service.ins.OrderBillService;
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
    @Resource
    private OrderBillService orderBillService;
    @Resource
    private ApplicationContext applicationContext;
    /**
     * 创建订单 unsafe
     */
    @GetMapping("/createBill")
    @ResponseBody
    public DockResult createBill() {
        DockResult<OrderBill> dockResult = orderBillService.createBill(OrderBill.builder("001"));
        if (dockResult.success()){
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
    public DockResult createBill4Safe() {
        return orderBillService.createBill(OrderBill.builder("001"));
    }
}
