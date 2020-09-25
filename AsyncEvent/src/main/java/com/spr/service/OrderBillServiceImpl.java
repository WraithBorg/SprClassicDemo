package com.spr.service;

import com.spr.entity.OrderBill;
import com.spr.mapper.OrderBillMapper;
import com.spr.result.DockResult;
import com.spr.service.ins.OrderBillService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * 订单Service
 */
@Service
public class OrderBillServiceImpl implements OrderBillService {
    @Resource
    private OrderBillMapper orderBillMapper;

    @Override
    public DockResult<OrderBill> createBill(OrderBill orderBill) {
        orderBillMapper.insert(orderBill);
        return DockResult.success(orderBill);
    }
}
