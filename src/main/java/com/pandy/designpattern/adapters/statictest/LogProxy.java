package com.pandy.designpattern.adapters.statictest;

/**
 * @author: Pandy
 * @create: 2022/3/19
 * 静态代理类
 * 实现日志扩展得功能
 * <p>
 * 要求：
 * 1. 和目标类实现同样得接口
 * 2. 在静态代理类中传入目标对象得实例，以便调用目标对象得方法
 * 3. 可以在静态代理得放啊中添加代理的逻辑代码
 **/
public class LogProxy implements UserService {

    private final UserService userService;

    public LogProxy(UserService userService) {
        this.userService = userService;
    }

    @Override
    public void save() {
        System.out.println("before===========save");
        userService.save();
        System.out.println("after===========save");
    }

    @Override
    public void delete() {
        System.out.println("before===========delete");
        userService.delete();
        System.out.println("after===========delete");
    }

    @Override
    public void update() {
        System.out.println("before===========update");
        userService.update();
        System.out.println("after===========update");
    }
}
