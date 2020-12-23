package Data;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.UUID;

import static org.junit.Assert.*;

class FirstObject extends HasData {

}


public class TestLifecycle01 extends AbstractTestNGSpringContextTests {
    @Autowired
    ApplicationContext context;

    @DataProvider
    Object[] [] getReference() {
        return new Object[][] {
                {"foo", true},
                {"bar", false}
        };
    }

    @Test(dataProvider = "getReference")
    public void testReferenceTypes(String name, boolean singleton) {
        HasData o1 = context.getBean(name, HasData.class);
        o1.setDatum(UUID.randomUUID().toString());

        HasData o2 = context.getBean(name, HasData.class);
        if(singleton) {
            assertSame(o1,o2);
            assertEquals(o1,o2);
            assertNotEquals(o1.getDatum(), o2.getDatum() );
        } else {
            assertNotSame(o1,o2);
            assertNotEquals(o1, o2);
            assertEquals(o1.getDatum(), o2.getDatum());

        }
    }

}
