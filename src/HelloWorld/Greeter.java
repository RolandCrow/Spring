package HelloWorld;

import java.io.PrintStream;

public interface Greeter {
    void setPrintStream(PrintStream printStream);
    void greet();
}

