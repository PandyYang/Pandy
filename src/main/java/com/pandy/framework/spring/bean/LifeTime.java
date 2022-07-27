package com.pandy.framework.spring.bean;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.*;

public class LifeTime implements BeanFactoryAware, BeanNameAware, InitializingBean, DisposableBean {

    private String name;
    private String address;
    private String phone;

    private BeanFactory beanFactory;
    private String beanName;

    public LifeTime() {
        System.out.println("构造器调用Person的构造器实例化");
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        System.out.println("输入属性name");
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        System.out.println("输入属性address");
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        System.out.println("输入属性phone");
        this.phone = phone;
    }

    public BeanFactory getBeanFactory() {
        return beanFactory;
    }

    public String getBeanName() {
        return beanName;
    }

    @Override
    public String toString() {
        return "LifeTime{" +
                "name='" + name + '\'' +
                ", address='" + address + '\'' +
                ", phone=" + phone +
                ", beanFactory=" + beanFactory +
                ", beanName='" + beanName + '\'' +
                '}';
    }

    @Override
    public void setBeanFactory(BeanFactory beanFactory) throws BeansException {
        System.out.println("调用BeanFactoryAware接口的setBeanFactory方法");
    }

    @Override
    public void setBeanName(String name) {
        System.out.println("调用BeanNameAware的setBeanName方法");
    }

    @Override
    public void destroy() throws Exception {
        System.out.println("调用Disposeable的destroy方法");
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println("调用InitializingBean的afterPropertiesSet方法，");
    }

    public void myInit(){
        System.out.println("调用init method的myInit方法");
    }

    public void myDestroy(){
        System.out.println("调用init destroy的myDestory方法");
    }
}
