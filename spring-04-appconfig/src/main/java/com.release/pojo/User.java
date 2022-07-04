package com.release.pojo;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * @author yancheng
 * @since 2022/6/14
 */
@Component
public class User {

    @Value("张三")
    public String name;

}
