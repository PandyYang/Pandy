package com.pandy.designpattern.strategy;

class FakeCls {
    // type: 优惠方式
    // 1：直减 2：满减:3：折扣:4：N元购
    void needPayAmount(int type, String otherParams) {
        if (type == 1) {
            // 直减相关逻辑
        } else if (type == 2) {
            // 满减相关逻辑
        } else if (type == 3) {
            // 折扣相关逻辑
        } else if (type == 4) {
            // N元购相关逻辑
        }
    }
}
