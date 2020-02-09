package web.servlet;

import entity.Employee;
import web.service.EmployeeService;
import web.service.impl.EmployeeServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class AddEmployeeServlet extends HttpServlet {
    private EmployeeService employeeService;

    @Override
    public void init() throws ServletException {
        employeeService = EmployeeServiceImpl.getInstance();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        getServletContext().getRequestDispatcher("/WEB-INF/pages/addEmployee.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Employee employee = new Employee();
        employee.setLastName(req.getParameterValues("lastName")[0]);
        employee.setFirstName(req.getParameterValues("firstName")[0]);
        employee.setDesignation(req.getParameterValues("designation")[0]);
        employee.setPhoneNumber(req.getParameterValues("phoneNumber")[0]);
        employeeService.addEmployee(employee);
        getServletContext().getRequestDispatcher("/index.jsp").forward(req, resp);
    }
}
