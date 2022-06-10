package com.pandy.designpattern.strategy;

public class WeXinPayStrategy implements PayStrategy {


    @Override
    public String toPay() {
        return "调用微信支付接口。。。。。";
    }
}
