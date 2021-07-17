package com.pandy.event;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Component;

@Component
public class EventDemoPublish {
    @Autowired
    private ApplicationEventPublisher applicationEventPublisher;

    public void publish(String name) {
        EventDemo demo = new EventDemo(this, name);
        applicationEventPublisher.publishEvent(demo);
    }
}
