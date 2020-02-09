package web.service;

import entity.Employee;
import sql.Queries;
import sql.SQLHandler;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public interface EmployeeService {

    List<Employee> getAllEmployees();

    boolean addEmployee(Employee employee);


}
