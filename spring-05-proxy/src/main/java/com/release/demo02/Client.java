package com.release.demo02;

/**
 * ้ๆไปฃ็
 * @author yancheng
 * @since 2022/6/14
 */
public class Client {
    public static void main(String[] args) {
        UserServiceImpl userService = new UserServiceImpl();

        UserServiceProxy proxy = new UserServiceProxy();
        proxy.setUserService(userService);
        proxy.add();
    }
}
