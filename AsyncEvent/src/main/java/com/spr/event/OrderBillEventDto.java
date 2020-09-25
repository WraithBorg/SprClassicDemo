package com.spr.event;

import com.spr.entity.OrderBill;
import com.spr.eum.OrderBillOperator;

public class OrderBillEventDto  {
    private OrderBillOperator oper;
    private OrderBill orderBill;

    /************************************* Constructor *************************************/
    public static OrderBillEventDto builder(OrderBillOperator oper, OrderBill orderBill) {
        return new OrderBillEventDto(oper, orderBill);
    }

    private OrderBillEventDto(OrderBillOperator oper, OrderBill orderBill) {
        this.oper = oper;
        this.orderBill = orderBill;
    }

    @Override
    public String toString() {
        return "OrderBillEventDto{" +
                "oper=" + oper +
                ", orderBill=" + orderBill +
                '}';
    }

    /************************************ Getter Setter ************************************/
    public OrderBillOperator getOper() {
        return oper;
    }

    public void setOper(OrderBillOperator oper) {
        this.oper = oper;
    }

    public OrderBill getOrderBill() {
        return orderBill;
    }

    public void setOrderBill(OrderBill orderBill) {
        this.orderBill = orderBill;
    }
}
