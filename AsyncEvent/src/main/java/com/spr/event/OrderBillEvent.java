package com.spr.event;

import org.springframework.context.ApplicationEvent;

public class OrderBillEvent extends ApplicationEvent {
    public OrderBillEvent(Object source) {
        super(source);
    }
}
