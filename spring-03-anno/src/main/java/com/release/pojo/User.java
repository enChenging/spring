package com.release.pojo;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

/**
 * @author yancheng
 * @since 2022/6/14
 */
@Component
@Scope("prototype")//作用域
public class User {
//    public String name = "release";
    @Value("release")
    public String name;
}
