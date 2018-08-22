import interfaces.Employees;

public class DaoFactory {
    private static Employees employeesDao;

    public static Employees getEmployeesDao(){
        if(employeesDao == null){
            employeesDao = new ListEmployeesDao();
        }

        return employeesDao;
    }



}
