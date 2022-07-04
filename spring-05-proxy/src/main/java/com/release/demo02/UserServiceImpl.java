package com.release.demo02;

/**
 * @author yancheng
 * @since 2022/6/14
 */
public class UserServiceImpl implements UserService{
    @Override
    public void add() {
        System.out.println("开始add");
    }

    @Override
    public void delete() {
        System.out.println("开始delete");
    }

    @Override
    public void update() {
        System.out.println("开始update");
    }

    @Override
    public void query() {
        System.out.println("开始query");
    }
}
