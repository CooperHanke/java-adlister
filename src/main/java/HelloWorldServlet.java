import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "HelloWorldServlet", urlPatterns = "/hello")
public class HelloWorldServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        handleRequest(request, response);
    }
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        handleRequest(request, response);
    }
    protected void handleRequest(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String param = request.getParameter("name");
        response.setContentType("text/html");
        response.getWriter().write("<h1>Hello there, " + param + "! Thanks for visiting!");
    }
}
