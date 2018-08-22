import interfaces.Employees;
import models.Employee;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;
@WebServlet(name = "createServlet", urlPatterns = "/employees/create")
public class CreateEmployeesServlet extends HttpServlet {

    Employees employeesDao = DaoFactory.getEmployeesDao();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        req.getRequestDispatcher("/employees/create.jsp").forward(req, resp);

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        Create a new employee

        // Gets the information from the request
        String firstName = req.getParameter("fn");
        String ln = req.getParameter("ln");
        char gender = req.getParameter("gender").charAt(0);
        String hd = req.getParameter("hd");
        String bd = req.getParameter("bd");

        // Creates a new employee instance
        Employee newEmployee = new Employee(bd, firstName,ln, gender, hd);

        employeesDao.insert(newEmployee);
        List<Employee> completeList = employeesDao.all();

        resp.sendRedirect("/employee?id=" + completeList.size() );

    }


}
