package com.pandy.base.designpattern.observer;

public interface Subject {
    public void registerObserver(Observer o); // 注册观察者
    public void removeObserver(Observer o); // 移除管擦或者
}
