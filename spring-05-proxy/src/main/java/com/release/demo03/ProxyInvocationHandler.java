package com.release.demo03;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @author yancheng
 * @since 2022/6/14
 */
//自动生成代理类
public class ProxyInvocationHandler implements InvocationHandler {

    //被代理的接口
    private Rent rent;
    public void setRent(Rent rent){
        this.rent = rent;
    }

    //生成得到的代理类
    public Object getProxy(){
        return Proxy.newProxyInstance(this.getClass().getClassLoader(),rent.getClass().getInterfaces(),this);
    }

    //处理代理实例，并返回结果
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        seeHouse();
        //动态代理的本质，就是使用反射机制实现
        Object result = method.invoke(rent, args);
        charge();
        return result;
    }

    //看房
    public void seeHouse(){
        System.out.println("中介带看房");
    }

    //收中介费
    public void charge(){
        System.out.println("收中介费");
    }
}
