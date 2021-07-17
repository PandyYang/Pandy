package com.pandy.elasticsearch.controller;

import com.pandy.elasticsearch.model.User;
import com.pandy.elasticsearch.service.UserService;
import com.pandy.elasticsearch.service.impl.SearchServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class TestController {

    @Autowired
    private UserService userService;

    @Autowired
    private SearchServiceImpl searchServiceImpl;

    @PostMapping("/test/add")
    public void testInsert() {
        User user = new User();
        user.setId("1");
        user.setName("zhangsna");
        user.setAge(101);
        user.setAddress("广东省深圳市");
        userService.save(user);

        user.setId("2");
        user.setName("lisi");
        user.setAge(32);
        user.setAddress("广东省深圳市");
        userService.save(user);

        user.setId("3");
        user.setName("wangwu");
        user.setAge(34);
        user.setAddress("广东省深圳市");
        userService.save(user);
    }

    @GetMapping("/test/getAll")
    public List<User> testGet() {
        return (List<User>) searchServiceImpl.getAll();
    }
}
