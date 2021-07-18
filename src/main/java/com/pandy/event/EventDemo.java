package com.pandy.event;

import org.springframework.context.ApplicationEvent;

public class EventDemo extends ApplicationEvent {
    private final String name;

    public EventDemo(EventDemoPublish eventDemoPublish, String name) {
        super(name);
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
