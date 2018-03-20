import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "Counter", urlPatterns = "/count")
public class Counter extends HttpServlet {
    private int counter = 0;

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String parameter = request.getParameter("reset");
        if (parameter == null || parameter.isEmpty()) {
            counter += 1;
            response.getWriter().println("<h1>The count is " + counter + ".</h1>");
        } else if (parameter.equalsIgnoreCase("true")) {
            response.getWriter().println("<h1>The count has now been reset!</h1>");
            counter = 0;
        } else {
            counter += 1;
            response.getWriter().println("<h1>The count is " + counter + ".</h1>");
        }
    }
}
