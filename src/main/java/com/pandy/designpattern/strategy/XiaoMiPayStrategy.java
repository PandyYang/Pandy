package com.pandy.designpattern.strategy;

public class XiaoMiPayStrategy implements PayStrategy {

    @Override
    public String toPay() {
        return "调用小米支付接口。。。。。";
    }
}
