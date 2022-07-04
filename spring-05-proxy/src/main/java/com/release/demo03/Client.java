package com.release.demo03;

/**
 * 动态代理
 * @author yancheng
 * @since 2022/6/14
 */
public class Client {
    public static void main(String[] args) {
        Host host = new Host();

        ProxyInvocationHandler proxyInvocationHandler = new ProxyInvocationHandler();
        proxyInvocationHandler.setRent(host);

        Rent proxy = (Rent) proxyInvocationHandler.getProxy();

        proxy.rent();
    }
}
