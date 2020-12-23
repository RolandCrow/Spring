package SpringBoot;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static org.junit.Assert.assertEquals;

public class TestGreetingController extends AbstractTestNGSpringContextTests {

    @Autowired
    private GreetingController greetingController;

    @LocalServerPort
    private int port;

    @Autowired
    private TestRestTemplate restTemplate;

    @DataProvider
    Object[][] greetingData() {
        return new Object[][] {
                new Object[]{null, "Hello World"},
                new Object[]{"World", "Hello, World!"},
                new Object[]{"Andrew", "Hello, Andrew"},
                new Object[]{"Jack Griffin", "I don't know."}

        };
    }

    @Test(dataProvider = "greetingData")
    public void testRestGreeting(String name, String greeting) {
        String url = "http://localhost:" + port + "/greeting/" +
                (name != null ? name: "");
        ResponseEntity<Greeting> result =
                restTemplate.getForEntity(url, Greeting.class);
        assertEquals(result.getStatusCode(), HttpStatus.OK);
        assertEquals(result.getBody().getMessage(), greeting);


    }



    @Test(dataProvider = "greetingData")
    public void testDirectGreeting(String name, String greeting) {
        assertEquals(greetingController.greeting(name).getMessage(), greeting);
    }

// 178


}
