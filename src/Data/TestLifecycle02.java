package Data;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.testng.annotations.Test;

import static org.junit.Assert.assertEquals;

class SecondObject extends HasData {

    SecondObject(String initialValue) {
        setDatum(initialValue);
    }


}

public class TestLifecycle02 extends AbstractTestNGSpringContextTests {
    @Autowired
    ApplicationContext context;

    @Test
    public void validateConstruction() {
        HasData o1 = context.getBean(HasData.class);
        assertEquals(o1.getDatum(), "Initial Value");

    }
}
