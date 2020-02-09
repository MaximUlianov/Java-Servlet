package sql;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.sql.*;
import java.util.List;

public class SQLHandler {

    private Connection connection;
    private Statement statement;

    public SQLHandler() {

    }

    public Connection openConnection() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            connection = DriverManager.getConnection(ConfigConstants.CONNECTION_URL,
                    ConfigConstants.USERNAME, ConfigConstants.PASSWORD);
            return connection;
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public void closeConnection() {
        try {
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void initTable() {
        try {
            List<String> queries = Files.readAllLines(Paths.get("C://buska//pism//lab1//src//main//resources//script.sql"));
            queries.forEach(query -> {
                try {
                    statement = connection.createStatement();
                    statement.executeUpdate(query);
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            });
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public ResultSet executeQuery(String sql) {
        try {
            return connection.createStatement().executeQuery(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

}
