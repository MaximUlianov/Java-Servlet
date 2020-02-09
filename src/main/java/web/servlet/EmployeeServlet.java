package web.servlet;

import entity.Employee;
import web.service.EmployeeService;
import web.service.impl.EmployeeServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

public class EmployeeServlet extends HttpServlet {

    private EmployeeService employeeService;

    @Override
    public void init() throws ServletException {
        employeeService = EmployeeServiceImpl.getInstance();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Employee> employees = employeeService.getAllEmployees();
        String lastName = req.getParameter("lastName");
        if (lastName != null && !lastName.equals("")) {
            employees = employees.stream().filter(employee -> lastName.equals(employee.getLastName())).collect(Collectors.toList());
        }
        req.setAttribute("employees", employees);
        getServletContext().getRequestDispatcher("/WEB-INF/pages/employeesPage.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        getServletContext().getRequestDispatcher("employee").forward(req, resp);
    }
}
