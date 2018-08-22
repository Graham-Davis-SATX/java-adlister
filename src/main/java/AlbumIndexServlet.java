import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "AlbumIndexServlet", urlPatterns = "/albums")
public class AlbumIndexServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Albums albumsDao = DaoFactory.getAlbumsDao();
        List<Album> albums = albumsDao.findAll();
        request.setAttribute("albums", albums);
        request.getRequestDispatcher("/WEB-INF/albums/index.jsp").forward(request, response);
    }
}
