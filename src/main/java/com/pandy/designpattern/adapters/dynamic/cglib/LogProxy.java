package com.pandy.designpattern.adapters.dynamic.cglib;

import org.springframework.cglib.proxy.Enhancer;
import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * @author: Pandy
 * @create: 2022/3/19
 **/
public class LogProxy {

    public static Object getProxy(Object target) {
        return Enhancer.create(
                target.getClass(),
                new MethodInterceptor() {
                    @Override
                    public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
                        String methodName = method.getName();
                        System.out.println("before=========" + methodName);

                        Object result = method.invoke(target, objects);

                        System.out.println("after=========" + methodName);

                        return methodName;
                    }
                }
        );
    }
}
