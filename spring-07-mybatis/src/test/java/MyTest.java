import com.release.mapper.DeptMapper;
import com.release.pojo.Dept;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

/**
 * @author yancheng
 * @since 2022/6/30
 */
public class MyTest {

    @Test
    public void test() throws IOException {
        String resources = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resources);
        SqlSessionFactory sessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        SqlSession sqlSession = sessionFactory.openSession(true);

        DeptMapper mapper = sqlSession.getMapper(DeptMapper.class);
        List<Dept> depts = mapper.selectDept();
        for (Dept dept : depts) {
            System.out.println(dept);
        }

    }

}
