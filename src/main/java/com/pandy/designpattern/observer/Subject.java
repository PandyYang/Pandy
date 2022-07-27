package com.pandy.designpattern.observer;

public interface Subject {
    void registerObserver(Observer o); // 注册观察者

    void removeObserver(Observer o); // 移除管擦或者
}
