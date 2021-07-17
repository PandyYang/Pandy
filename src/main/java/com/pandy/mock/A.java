package com.pandy.mock;

public class A {
    String foo1() {
        foo2();
        return "RealString1";
    }

    String foo2() {
        return "RealString_2";
    }

    void foo3() {
        //foo4();
    }
}
