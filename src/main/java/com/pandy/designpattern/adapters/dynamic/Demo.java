package com.pandy.designpattern.adapters.dynamic;

import com.pandy.designpattern.adapters.statictest.UserService;
import com.pandy.designpattern.adapters.statictest.UserServiceImpl;
import com.pandy.elasticsearch.model.User;

/**
 * @author: Pandy
 * @create: 2022/3/19
 **/
public class Demo {

    public static void main(String[] args) {
        UserService userService = new UserServiceImpl();
        UserService proxy = (UserService) LogProxy.getProxy(userService);
        proxy.save();
        proxy.delete();
        proxy.update();
    }
}
