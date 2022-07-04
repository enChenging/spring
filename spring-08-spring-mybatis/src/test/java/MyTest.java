import com.release.mapper.DeptMapper;
import com.release.pojo.Dept;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

/**
 * @author yancheng
 * @since 2022/6/30
 */
public class MyTest {

    @Test
    public void test() {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        DeptMapper detpMapper = context.getBean("detpMapper", DeptMapper.class);
        List<Dept> depts = detpMapper.selectDept();
        for (Dept dept : depts) {
            System.out.println(dept);
        }

    }

    @Test
    public void test2() {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        DeptMapper detpMapper = context.getBean("detpMapper2", DeptMapper.class);
        List<Dept> depts = detpMapper.selectDept();
        for (Dept dept : depts) {
            System.out.println(dept);
        }

    }

}
