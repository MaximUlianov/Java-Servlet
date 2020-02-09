package sql;

public class Queries {
    public static final String GET_ALL_EMPLOYEES = "select * from employee";
    public static final String ADD_EMPLOYEE = "insert into ief.employee " +
            "(first_name, last_name, designation, phone_number) values (?, ?, ?, ?)";
}
