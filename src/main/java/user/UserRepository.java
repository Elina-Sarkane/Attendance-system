package user;

import database.DBHandler;

import java.sql.*;
import java.util.ArrayList;

public class UserRepository {
    private DBHandler dbHandler = new DBHandler();

    /*public void logInUser(User user) throws SQLException{

    }*/

    public void addUser(User user) throws SQLException {
        Connection connection = dbHandler.getConnection();
        String query = "INSERT INTO users(name, email, status) VALUES(?,?,?)";
        PreparedStatement preparedStatement = dbHandler.getConnection().prepareStatement(query);
        preparedStatement.setString(1, user.name);
        preparedStatement.setString(2, user.email);
        preparedStatement.setString(3, user.status);
        preparedStatement.execute();

        preparedStatement.close();
    }

    public User getAllUsers(Integer userId) throws SQLException {
        User user;
        String query = "SELECT * FROM users WHERE id = " + userId + "LIMIT 1";
        Statement statement = dbHandler.getConnection().createStatement();

        ResultSet resultSet = statement.executeQuery(query);

        resultSet.next();
        user = new User(
                resultSet.getInt("userId"),
                resultSet.getString("name"),
                resultSet.getString("email"),
                resultSet.getString("status"),
                resultSet.getString("created_at"),
                resultSet.getString("last_updated")
        );

        statement.close();
        return user;
    }

    public ArrayList<User> getAllActiveUsers(String status) throws SQLException {
        String query = "SELECT * FROM users WHERE status = 'Active'";
        Statement statement = dbHandler.getConnection().createStatement();

        ResultSet resultSet = statement.executeQuery(query);

        ArrayList<User> users = new ArrayList<User>();

        while (resultSet.next()) {
            users.add(new User(
            resultSet.getInt("userId"),
            resultSet.getString("name"),
            resultSet.getString("email"),
            resultSet.getString("status"),
            resultSet.getString("created_at"),
            resultSet.getString("last_updated")
        ));
        }
        statement.close();
        return users;
    }

    public ArrayList<User> getAllInactiveUsers(String status) throws SQLException {
        String query = "SELECT * FROM users WHERE status = 'Inactive'";
        Statement statement = dbHandler.getConnection().createStatement();

        ResultSet resultSet = statement.executeQuery(query);

        ArrayList<User> users = new ArrayList<User>();

        while (resultSet.next()) {
            users.add(new User(
                    resultSet.getInt("userId"),
                    resultSet.getString("name"),
                    resultSet.getString("email"),
                    resultSet.getString("status"),
                    resultSet.getString("created_at"),
                    resultSet.getString("last_updated")
            ));
        }
        statement.close();
        return users;
    }

    public ArrayList<User> updateUserStatusToActive(String status) throws SQLException {
        String query = "UPDATE users SET status = 'Active' WHERE status = 'Inactive'";
        Statement statement = dbHandler.getConnection().createStatement();

        ResultSet resultSet = statement.executeQuery(query);

        ArrayList<User> users = new ArrayList<User>();

        while (resultSet.next()) {
            users.add(new User(
                    resultSet.getInt("userId"),
                    resultSet.getString("name"),
                    resultSet.getString("email"),
                    resultSet.getString("status"),
                    resultSet.getString("created_at"),
                    resultSet.getString("last_updated")
            ));
        }
        statement.close();
        return users;
    }

    public ArrayList<User> updateUserStatusToInactive(String status) throws SQLException {
        String query = "UPDATE users SET status = 'Inactive' WHERE status = 'Active'";
        Statement statement = dbHandler.getConnection().createStatement();

        ResultSet resultSet = statement.executeQuery(query);

        ArrayList<User> users = new ArrayList<User>();

        while (resultSet.next()) {
            users.add(new User(
                    resultSet.getInt("userId"),
                    resultSet.getString("name"),
                    resultSet.getString("email"),
                    resultSet.getString("status"),
                    resultSet.getString("created_at"),
                    resultSet.getString("last_updated")
            ));
        }
        statement.close();
        return users;
    }

    public ArrayList<User> deleteUser(String status) throws SQLException{
        String query = "DELETE FROM users WHERE status = 'Inactive'";
        Statement statement = dbHandler.getConnection().createStatement();
        ResultSet resultSet = statement.executeQuery(query);

        ArrayList<User> users = new ArrayList<>();

        while (resultSet.next()){
            users.remove("Active");
        }
        statement.close();
        return users;
    }

    /*public ArrayList<User> getAllUsersFromSingleDay() throws SQLException{
        String query = "SELECT * FROM users WHERE last_updated LIKE '%" + last_updated + "%'";
        Statement statement = dbHandler.getConnection().createStatement();

        ResultSet resultSet = statement.executeQuery(query);

        ArrayList<User> users = new ArrayList<User>();

        while (resultSet.next()){
            int userId = resultSet.getInt("userId");
            String name = resultSet.getString("name");
            String status = resultSet.getString("status");
            String created_at = resultSet.getString("created_at");
            String last_updated = resultSet.getString("last_updated");

            users.add(new User(userId, name, status, created_at, last_updated));
        }
        statement.close();
        return users;
    }
}*/

}