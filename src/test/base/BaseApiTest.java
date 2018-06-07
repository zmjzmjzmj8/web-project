package base;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * java类简单作用描述
 *
 * @ClassName: ${TYPE_NAME}
 * @Description: java类作用描述
 * @Author: zhaomingjie
 * @CreateDate: 2018/5/28 18:11
 * @UpdateUser: zhaomingjie
 * @UpdateDate: 2018/5/28 18:11
 * @UpdateRemark: The modified content
 * @Version: 1.0
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:/META-INF/spring/applicationContext2.xml",
        "classpath:/META-INF/spring/spring-mvc2.xml"   })
public class BaseApiTest {
    @Test
    public void test(){

    }
}
