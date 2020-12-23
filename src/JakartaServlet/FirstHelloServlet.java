package JakartaServlet;

import org.jtwig.web.servlet.JtwigRenderer;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(urlPatterns = "/hello1")
public class FirstHelloServlet {

    private static final long serialVersionUID = -4427011101374936594L;
    private final JtwigRenderer renderer = JtwigRenderer.defaultRenderer();


    protected  void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        renderer.dispatcherFor("/resources/hello.jtwig.html")
                .with("name", "world")
                .render(request, response);

    }


}
