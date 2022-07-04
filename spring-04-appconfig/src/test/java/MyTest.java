import com.release.config.ReleaseConfig;
import com.release.pojo.User;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @author yancheng
 * @since 2022/6/14
 */
public class MyTest {

    @Test
    public void Test() {
        //如果完全使用了配置类方式去做，我们就只能通过AnnotationConfig上下文来获取容器，通过配置类的class对象加载
        ApplicationContext context = new AnnotationConfigApplicationContext(ReleaseConfig.class);
        User user = context.getBean("getUser", User.class);
        System.out.println(user.name);
    }
}
