package Data;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.testng.annotations.Test;

import static junit.framework.TestCase.*;

class ThirdObject extends  HasData{
    static Object semaphore = null;
    public void init() {
        semaphore = new Object();

    }
    public void dispose() {
        semaphore = null;
    }

}

public class TestLifecycle03 extends AbstractTestNGSpringContextTests {
    @Autowired
    ConfigurableApplicationContext context;

    @Test
    public void testInitDestroyMethods() {
        ThirdObject o1 = context.getBean(ThirdObject.class);
        assertNotNull(ThirdObject.semaphore);
        assertEquals(o1.getDatum(), "default");
        assertNull(ThirdObject.semaphore);
    }
}
// p 109
