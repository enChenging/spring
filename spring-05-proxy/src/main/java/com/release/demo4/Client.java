package com.release.demo4;

import com.release.demo02.UserService;
import com.release.demo02.UserServiceImpl;

/**
 * @author yancheng
 * @since 2022/6/14
 */
public class Client {
    public static void main(String[] args) {
        UserServiceImpl userService = new UserServiceImpl();

        ProxyInvocationHandler proxyInvocationHandler = new ProxyInvocationHandler();
        proxyInvocationHandler.setTarget(userService);

        UserService proxy = (UserService) proxyInvocationHandler.getProxy();

        proxy.query();
    }
}
