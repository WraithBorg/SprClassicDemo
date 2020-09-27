package com.spr.event;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.aop.interceptor.AsyncUncaughtExceptionHandler;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.AsyncConfigurer;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

import java.lang.reflect.Method;
import java.util.concurrent.Executor;

/**
 * 自定义Spring线程池
 */
@Configuration
@EnableAsync
public class SprAsyncConfig implements AsyncConfigurer {
    private final Logger LOGGER = LoggerFactory.getLogger(SprAsyncConfig.class);

    @Override
    public Executor getAsyncExecutor() {
        ThreadPoolTaskExecutor taskExecutor = new ThreadPoolTaskExecutor();
        // 核心线程数
        taskExecutor.setCorePoolSize(2);
        //  最大线程数
        taskExecutor.setMaxPoolSize(10);
        // 队列大小
        taskExecutor.setQueueCapacity(15);
        // 线程名的前缀
        taskExecutor.setThreadNamePrefix("spr-async-thread-");
        taskExecutor.initialize();
        return taskExecutor;

    }

    /**
     * 捕捉IllegalArgumentException异常
     */
    @Override
    public AsyncUncaughtExceptionHandler getAsyncUncaughtExceptionHandler() {
        return new MyAsyncExceptionHandler();
    }

    class MyAsyncExceptionHandler implements AsyncUncaughtExceptionHandler {
        @Override
        public void handleUncaughtException(Throwable throwable, Method method, Object... objects) {
            LOGGER.info("TASK   Exception   message   -   " + throwable.getMessage());
            LOGGER.info("Method   name   -   " + method.getName());
            for (Object param : objects) {
                LOGGER.info("Parameter   value   -   " + param);
            }
        }
    }
}
    
