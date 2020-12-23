package Data;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.stereotype.Component;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.testng.annotations.Test;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import static org.junit.Assert.*;

@Component
class SeventhObject extends HasData {
    static  Object semaphore = null;

    @PostConstruct
    public void initialize() throws Exception {
        semaphore = new Object();
    }

    @PreDestroy
    public void dispose() throws Exception {
        semaphore = null;
    }



}



public class TestLifecycle06 extends AbstractTestNGSpringContextTests {
    @Autowired
    ConfigurableApplicationContext context;

    @Test
    public void testInitDestroyMethods() {
        SeventhObject o1 = context.getBean(SeventhObject.class);
        assertNotNull(SeventhObject.semaphore);
        assertEquals(o1.getDatum(), "default");
        context.close();
        assertNull(SeventhObject.semaphore);
    }



}
