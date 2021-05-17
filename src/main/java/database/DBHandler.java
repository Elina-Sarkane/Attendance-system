package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBHandler {
    // jdbc:mysql://127.0.0.1:3306/?user=java_18
    String connectionUrl = "jdbc:mysql://localhost:3306/attendance?serverTimeZone=UTC";
    String user = "java_18";
    String password = "java18";

    private Connection connection;

    public DBHandler(){
        try {
            connection = DriverManager.getConnection(connectionUrl, user, password);
        } catch (SQLException e){
            System.out.println("Unable to connect to attendance");
            e.printStackTrace();
        }
    }
    public Connection getConnection(){
        return connection;
    }
}
