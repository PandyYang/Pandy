package com.pandy.event;

import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

@Component
public class EventDemoListener implements ApplicationListener<EventDemo> {
    @Override
    public void onApplicationEvent(EventDemo eventDemo) {
        System.out.println("接收者：" + eventDemo.getName());
    }
}
