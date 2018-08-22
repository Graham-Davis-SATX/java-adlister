import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet(name = "ColorPreferenceServlet", urlPatterns = "/color-profile")
public class ColorPreferenceServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        HttpSession session = request.getSession();

        if (request.getParameter("forget") != null) {
            session.invalidate();
            session.removeAttribute("background");
            session.removeAttribute("fontColor");
        }

        if (request.getParameter("background") != null) {
            String background = request.getParameter("background");
            if (background.length() > 0) {
                System.out.println("SETTING BACKGROUND");
                session.setAttribute("background", background);
            }
        }

        if (request.getParameter("font-color") != null) {
            String fontColor = request.getParameter("font-color");
            if (fontColor.length() > 0) {
                System.out.println("SETTING FONT COLOR");
                session.setAttribute("fontColor", fontColor);
            }
        }

        response.sendRedirect("/ads");

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("/color-profile-form.jsp").forward(request, response);
    }
}
