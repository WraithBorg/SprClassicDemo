package com.spr.event;

import com.spr.eum.OrderBillOperator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.event.EventListener;
import org.springframework.core.annotation.Order;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

@Component
public class OrderBillEventListener {
    private static final Logger LOGGER = LoggerFactory.getLogger(OrderBillEventListener.class);

    /**
     * spring 监听器 高级应用
     */
    @Order(2)
    @Async
    @EventListener(value = {SprComplexEvent4CreateBill.class, SprComplexEvent4UpdateBill.class}, condition = "#event.sprUser.age > 18")
    public void testComplexEvent(SprComplexEvent event) {
        LOGGER.info("监听事件：" + event.getSprUser());
    }

    /**
     * spring 监听器
     */
    @Async
    @EventListener
    @Order(value = 1)
    public void onApplicationEvent(OrderBillEvent orderBillEvent) {
        OrderBillEventDto eventDto = (OrderBillEventDto) orderBillEvent.getSource();
        if (eventDto.getOper().equals(OrderBillOperator.CREATE)) {
            LOGGER.info("发送下单成功短信-START：{}", eventDto.getOrderBill().getCode());
            try {
                Thread.sleep(3 * 1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            LOGGER.info("发送下单成功短信-END：{}", eventDto.getOrderBill().getCode());
        } else {
            LOGGER.error("尚不支持该事件L:{}！", eventDto.getOper());
        }
    }


}
