package com.release.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * @author yancheng
 * @since 2022/3/15
 */
@Data
@AllArgsConstructor
public class Dept {

    private Long deptno;
    private String dname;
    private String db_source;

}
