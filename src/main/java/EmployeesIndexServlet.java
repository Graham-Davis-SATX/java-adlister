import interfaces.Employees;
import models.Employee;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "empServlet", urlPatterns = "/employees/index")
public class EmployeesIndexServlet extends HttpServlet {

    Employees employeesDao = DaoFactory.getEmployeesDao();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        // This is how you add a new record in the Dao
//        employeesDao.insert(new Employee("-", "Stacy", "Mendoza",'F',"-"));

        Employee emp = employeesDao.find(3);

        System.out.println(emp.getFirstName());

        List<Employee> peopleHired = employeesDao.all();

        req.setAttribute("peopleHired", peopleHired);

        req.getRequestDispatcher("/employees/index.jsp").forward(req, resp);

    }
}
