package com.pandy.designpattern.adapters.statictest;

import com.pandy.base.test.ForTest.User;

/**
 * @author: Pandy
 * @create: 2022/3/19
 **/
public class Test {

    public static void main(String[] args) {
        UserService userService = new UserServiceImpl();

        UserService logProxy = new LogProxy(userService);

        logProxy.save();
        logProxy.update();
        logProxy.delete();
    }

}
