package Data;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.stereotype.Component;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.testng.annotations.Test;

import static org.junit.Assert.*;

@Component
class EightObject extends HasData implements InitializingBean, DisposableBean {
    static Object semaphore = null;

    @Override
    public void afterPropertiesSet() throws Exception {
        semaphore = new Object();
    }

    @Override
    public void destroy() throws Exception {
        semaphore  = null;
    }
}



public class TestLifecycle07 extends AbstractTestNGSpringContextTests {

    @Autowired
    ConfigurableApplicationContext context;


    @Test
    public void testLifecycleMethods() {
        EightObject o1 = context.getBean(EightObject.class);
        assertNotNull(EightObject.semaphore);
        assertEquals(o1.getDatum(), "default");
        context.close();
        assertNull(EightObject.semaphore);
    }


}
