package com.pandy.designpattern.strategy;

public class AliPayStrategy implements PayStrategy {
    @Override
    public String toPay() {
        return "调用支付宝接口。。。。。";
    }
}
