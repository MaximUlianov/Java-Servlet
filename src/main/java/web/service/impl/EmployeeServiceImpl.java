package web.service.impl;

import entity.Employee;
import sql.Queries;
import sql.SQLHandler;
import web.service.EmployeeService;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class EmployeeServiceImpl implements EmployeeService {

    private static EmployeeServiceImpl instance;

    public static synchronized EmployeeServiceImpl getInstance(){
        if (instance == null) {
            instance = new EmployeeServiceImpl();
        }
        return instance;
    }

    @Override
    public List<Employee> getAllEmployees()  {
        List<Employee> employees = new ArrayList<>();
        SQLHandler sqlHandler = new SQLHandler();
        sqlHandler.openConnection();
        ResultSet resultSet = sqlHandler.executeQuery(Queries.GET_ALL_EMPLOYEES);
        try {
            while (resultSet.next()) {
                Employee employee = new Employee();
                employee.setId(resultSet.getLong(1));
                employee.setFirstName(resultSet.getString(2));
                employee.setLastName(resultSet.getString(3));
                employee.setDesignation(resultSet.getString(4));
                employee.setPhoneNumber(resultSet.getString(5));
                employees.add(employee);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            sqlHandler.closeConnection();
        }
        return employees;
    }

    @Override
    public boolean addEmployee(Employee employee) {
        SQLHandler sqlHandler = new SQLHandler();
        Connection connection = sqlHandler.openConnection();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(Queries.ADD_EMPLOYEE);
            preparedStatement.setString(1, employee.getFirstName());
            preparedStatement.setString(2, employee.getLastName());
            preparedStatement.setString(3, employee.getDesignation());
            preparedStatement.setString(4, employee.getPhoneNumber());
            preparedStatement.executeUpdate();
            sqlHandler.closeConnection();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }
}
