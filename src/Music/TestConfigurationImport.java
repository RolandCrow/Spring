package Music;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static junit.framework.TestCase.assertNotNull;
import static org.apache.tools.ant.taskdefs.SetPermissions.NonPosixMode.fail;
import static org.junit.Assert.fail;

public class TestConfigurationImport extends AbstractTestNGSpringContextTests {

    @Autowired
    ApplicationContext context;

    @DataProvider
    Object [] [] resources() {
        return new Object[][]{
                {"musicServiceTests"},
                {MusicServiceTest.class},
                {"foo"},
                {"bar"},
                {CapLeadingNormalizer.class},
                {"musicService4"}
        };
    }

    @Test(dataProvider = "resources")
    public void validateResourcesExistence(Object resource) {
        if(resource instanceof  String) {
         assertNotNull(context.getBean(resource.toString()));
        } else {
            if(resource instanceof Class<?>) {
                assertNotNull(context.getBean((Class<?>) resource ));
            } else {
                fail("Invalid resource type");
            }
        }
    }






}
