package com.release.pojo;

/**
 * @author yancheng
 * @since 2022/6/13
 */
public class Cat {
    private String name;
    private int age;

    public void shout(){
        System.out.println("猫叫~~~");
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
