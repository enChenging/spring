package com.release.demo01;

/**
 * @author yancheng
 * @since 2022/6/14
 */
//房东
public class Host implements Rent {


    @Override
    public void rent() {
        System.out.println("房东要出租房子");
    }
}
