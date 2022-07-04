package com.release.diy;

/**
 * @author yancheng
 * @since 2022/6/14
 */
public class DiyPointCut {

    public void before(){
        System.out.println("==================方法执行前====================");
    }

    public void after(){
        System.out.println("==================方法执行后====================");
    }
}
