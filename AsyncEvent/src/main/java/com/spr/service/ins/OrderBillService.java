package com.spr.service.ins;

import com.spr.entity.OrderBill;
import com.spr.result.DockResult;

public interface OrderBillService {
    public DockResult<OrderBill> createBill(OrderBill orderBill);
}
