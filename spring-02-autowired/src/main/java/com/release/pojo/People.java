package com.release.pojo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import javax.annotation.Resource;

/**
 * @author yancheng
 * @since 2022/6/13
 */
public class People {
    private String name;
    private int age;
    //如果显示定义为了Autowired的required = false，说明这个对象可以为null,否则不允许为空
    @Autowired(required = false)
    @Qualifier(value = "dog")
    private Dog dog;
    @Resource
    private Cat cat;

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

    public Dog getDog() {
        return dog;
    }

    public void setDog(Dog dog) {
        this.dog = dog;
    }

    public Cat getCat() {
        return cat;
    }

    public void setCat(Cat cat) {
        this.cat = cat;
    }
}
