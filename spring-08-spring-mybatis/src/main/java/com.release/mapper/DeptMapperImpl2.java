package com.release.mapper;

import com.release.pojo.Dept;
import org.mybatis.spring.support.SqlSessionDaoSupport;

import java.util.List;

/**
 * 方式二：
 * @author yancheng
 * @since 2022/7/1
 */
public class DeptMapperImpl2 extends SqlSessionDaoSupport implements DeptMapper {
    @Override
    public List<Dept> selectDept() {
        DeptMapper mapper = getSqlSession().getMapper(DeptMapper.class);
        return mapper.selectDept();
    }
}
