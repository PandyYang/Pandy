package com.pandy.spring.bean;

import com.uwyn.jhighlight.fastutil.Hash;
import org.springframework.beans.BeansException;
import org.springframework.beans.PropertyValue;
import org.springframework.beans.PropertyValues;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;

import java.util.HashMap;

public class MyBenFactoryPostProcessor implements BeanFactoryPostProcessor {
    @Override
    public void postProcessBeanFactory(ConfigurableListableBeanFactory beanFactory) throws BeansException {
        System.out.println("BeanFactoryPostProcessor调用postProcessBeanFactory方法");
        BeanDefinition lifttime = beanFactory.getBeanDefinition("lifeTime");
        HashMap<String, String> hashMap = new HashMap<>();
        hashMap.put("phone", "110");
        lifttime.getPropertyValues().addPropertyValues(hashMap);
    }
}
