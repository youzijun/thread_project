package com.ltt.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * Created by ZJX-BJ-01-00057 on 2019/5/20.
 */
public class ProxyHandler implements InvocationHandler{

    private Object target;

    public ProxyHandler(Object target) {
        this.target = target;
    }


    public Object getProxyObj(){
        return Proxy.newProxyInstance(target.getClass().getClassLoader(),target.getClass().getInterfaces(),this);
    }


    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("before...");
        Object result = method.invoke(target, args);
        System.out.println("after...");

        return result;
    }
}
