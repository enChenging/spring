import com.release.mapper.DeptMapper;
import com.release.pojo.Dept;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

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


}
