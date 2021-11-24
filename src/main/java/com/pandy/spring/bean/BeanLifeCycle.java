package com.pandy.spring.bean;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class BeanLifeCycle {
    public static void main(String[] args) {
        ApplicationContext factory = new ClassPathXmlApplicationContext("bean.xml");
        System.out.println("容器初始化成功");
        LifeTime lifeTime = factory.getBean("lifeTime", LifeTime.class);
        System.out.println(lifeTime);
        System.out.println("关闭容器");
        ((ClassPathXmlApplicationContext)factory).registerShutdownHook();
    }
}
