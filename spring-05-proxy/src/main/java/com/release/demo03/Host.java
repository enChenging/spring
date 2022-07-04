package com.release.demo03;

/**
 * 房东
 * @author yancheng
 * @since 2022/6/14
 */
public class Host implements Rent {


    @Override
    public void rent() {
        System.out.println("房东要出租房子");
    }
}
