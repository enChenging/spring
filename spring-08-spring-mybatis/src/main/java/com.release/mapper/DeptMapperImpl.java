package com.release.mapper;

import com.release.pojo.Dept;
import org.mybatis.spring.SqlSessionTemplate;

import java.util.List;

/**
 * 方式一：
 * @author yancheng
 * @since 2022/7/1
 */
public class DeptMapperImpl implements DeptMapper {
    //我们的所有操作，都使用sqlSession来执行，在原来，现在都使用sqlSessionTemplate
    private SqlSessionTemplate sqlSessionTemplate;

    public void setSqlSessionTemplate(SqlSessionTemplate sqlSessionTemplate){
        this.sqlSessionTemplate = sqlSessionTemplate;
    }

    @Override
    public List<Dept> selectDept() {
        DeptMapper mapper = sqlSessionTemplate.getMapper(DeptMapper.class);
        return mapper.selectDept();
    }
}
