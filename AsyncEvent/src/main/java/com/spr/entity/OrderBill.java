package com.spr.entity;

import java.util.Date;

/**
 * 订单
 */
public class OrderBill {
    private String code;//单号
    private Date createdAt;//创建日期
    private Date updatedAt;//修改日期

    /************************************* Constructor *************************************/
    private OrderBill() {
    }

    private OrderBill(String code) {
        this.code = code;
        this.createdAt = new Date();
        this.updatedAt = new Date();
    }

    public static OrderBill builder(String code) {
        return new OrderBill(code);
    }

    @Override
    public String toString() {
        return "OrderBill{" +
                "code='" + code + '\'' +
                ", createdAt=" + createdAt +
                ", updatedAt=" + updatedAt +
                '}';
    }

    /************************************ Getter Setter ************************************/
    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public Date getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(Date updatedAt) {
        this.updatedAt = updatedAt;
    }
}
