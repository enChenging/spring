package com.release.demo01;

/**
 * 静态代理
 * @author yancheng
 * @since 2022/6/14
 */
public class Client {
    public static void main(String[] args) {
        Host host = new Host();
        //代理
        Proxy proxy = new Proxy(host);
        proxy.rent();
    }
}
