import interfaces.Employees;
import models.Employee;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "showEmp", urlPatterns = "/employee")
public class ShowEmployeeServlet extends HttpServlet {

    Employees employeesDao = DaoFactory.getEmployeesDao();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        long id = Long.parseLong(req.getParameter("id"));

        Employee existingEmployee = employeesDao.find(id);

        req.setAttribute("emp", existingEmployee);

        req.getRequestDispatcher("/employees/show.jsp").forward(req, resp);


    }
}
