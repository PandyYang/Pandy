package com.pandy.designpattern.adapters.dynamic;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @author: Pandy
 * @create: 2022/3/19
 * <p>
 * 用于生成JDK动态代理
 **/
public class LogProxy {

    /**
     * 生成动态代理对象的方法
     *
     * @param target 传入的目标对象
     * @return 生成的JDK动态代理对象
     */
    public static Object getProxy(Object target) {

        /**
         * 参数1： 类加载器，JDK动态代理底层是使用类加载器来生产一个动态类的，通常传入当前类的加载器即可。
         * 参数2： 目标对象的接口列表，通常使用目标对象获取接口列表。
         * 参数3： 接口，用户编写代理逻辑代码。通常需要一个InvocationHandler接口的实现类，匿名内部类的方式提供。
         */
        return Proxy.newProxyInstance(
                LogProxy.class.getClassLoader(),
                target.getClass().getInterfaces(),
                new InvocationHandler() {

                    /**
                     * invoke方法： 用于编写代理类的代理逻辑代码。
                     *      该方法会在调用JDK代理对象的每个方法的时候被执行。
                     *
                     * @param proxy 生成JDK动态代理对象
                     * @param method 目标对象的执行方法的对象
                     * @param args 目标对象的方法参数列表
                     * @return 目标对方法执行之后的返回结果
                     * @throws Throwable
                     */
                    @Override
                    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                        String name = method.getName();
                        System.out.println("before =========== " + name);

                        // 调用目标对象方法
                        Object result = method.invoke(target, args);
                        System.out.println("after===========" + name);

                        return result;
                    }
                }
        );
    }
}
