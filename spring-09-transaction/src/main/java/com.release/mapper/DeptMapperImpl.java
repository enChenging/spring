package com.release.mapper;

import com.release.pojo.Dept;
import org.mybatis.spring.support.SqlSessionDaoSupport;

import java.util.List;

/**
 * 方式二：
 * @author yancheng
 * @since 2022/7/1
 */
public class DeptMapperImpl extends SqlSessionDaoSupport implements DeptMapper {
    @Override
    public List<Dept> selectDept() {
        Dept dept = new Dept(6L, "成长", "db01");
        DeptMapper mapper = getSqlSession().getMapper(DeptMapper.class);
        mapper.addDept(dept);
        mapper.deleteDept(6L);
        return mapper.selectDept();
    }

    @Override
    public int addDept(Dept dept) {
        return getSqlSession().getMapper(DeptMapper.class).addDept(dept);
    }

    @Override
    public int deleteDept(long id) {
        return getSqlSession().getMapper(DeptMapper.class).deleteDept(id);
    }
}
