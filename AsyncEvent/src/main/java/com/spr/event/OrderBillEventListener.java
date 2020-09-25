package com.spr.event;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.event.EventListener;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

@Component
public class OrderBillEventListener {
    private static final Logger LOGGER = LoggerFactory.getLogger(OrderBillEventListener.class);
    @Async
    @EventListener
    public void onApplicationEvent(OrderBillEvent orderBillEvent) {
        OrderBillEventDto eventDto = (OrderBillEventDto) orderBillEvent.getSource();
        LOGGER.info("发送下单成功短信-START：{}", eventDto.getOrderBill().getCode());
        try {
            Thread.sleep(3 * 1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        LOGGER.info("发送下单成功短信-END：{}", eventDto.getOrderBill().getCode());
    }
}
