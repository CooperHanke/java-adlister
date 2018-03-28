import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(urlPatterns = "/name")
public class NameServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        request.getRequestDispatcher("/name.jsp").forward(request, response);
    }
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        if (request.getParameter("name").isEmpty()) {
            request.getRequestDispatcher("/name.jsp").forward(request, response);
        } else {
            request.setAttribute("name", request.getParameter("name"));
            request.setAttribute("title", "Hello " + request.getAttribute("name"));
            request.getRequestDispatcher("/surprise.jsp").forward(request, response);
        }
    }
}
