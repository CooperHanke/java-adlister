import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "ColorPicker", urlPatterns = "/colorpicker")
public class ColorPicker extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("/colorpicker.jsp").forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        if (request.getParameter("color").isEmpty()) {
            request.getRequestDispatcher("/colorpicker.jsp").forward(request, response);
        }
        else {
            request.setAttribute("color", request.getParameter("color"));
            request.setAttribute("title", request.getParameter("color"));
            request.getRequestDispatcher("/color.jsp").forward(request, response);
        }
    }
}
