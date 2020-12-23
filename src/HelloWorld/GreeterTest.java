package HelloWorld;


import org.junit.Test;
import org.springframework.core.io.ByteArrayResource;
import static org.junit.Assert.*;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.io.UnsupportedEncodingException;
import java.nio.charset.StandardCharsets;

public class GreeterTest {
    @Test
    public void testHelloWorld() {
        Greeter greeter = new HelloWorldGreeter();
        final ByteArrayOutputStream baos = new ByteArrayOutputStream();
        try(PrintStream ps = new PrintStream(baos, true)) {
            greeter.setPrintStream(ps);
            greeter.greet();
        }
    String data = new String(baos.toByteArray(), StandardCharsets.UTF_8);
            assertEquals(data, "Hello World");

    }


    }

