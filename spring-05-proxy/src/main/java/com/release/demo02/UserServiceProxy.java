package com.release.demo02;

/**
 * @author yancheng
 * @since 2022/6/14
 */
public class UserServiceProxy implements UserService {

    private UserServiceImpl userService;

    public void setUserService(UserServiceImpl userService){
        this.userService = userService;
    }

    @Override
    public void add() {
        System.out.println("使用了add方法");
        userService.add();
    }

    @Override
    public void delete() {
        System.out.println("使用了delete方法");
        userService.delete();
    }

    @Override
    public void update() {
        System.out.println("使用了update方法");
        userService.update();
    }

    @Override
    public void query() {
        System.out.println("使用了query方法");
        userService.query();
    }
}
