package user;

import java.sql.SQLException;
import java.util.ArrayList;

public class UserController {
    UserRepository userRepository = new UserRepository();

    /*public String userLogIn(User user){
        try {
            userRepository.logInUser(user);
        }catch (SQLException e){
            e.printStackTrace();
            return "Error logging in";
        }
        return "Logged in successfully";
    }*/

    public String createUser(User user) {
        try {
            userRepository.addUser(user);
        } catch (SQLException e) {
            e.printStackTrace();
            return "Error with creating user";
        }
        if (user.status.equalsIgnoreCase("active")) {
            return "User created successfully!";
        } else {
            return "Inactive users can't fill in attendance";
        }
    }

    public User findUsers(Integer userId) {
        User user = null;

        try {
            user = userRepository.getAllUsers(userId);
        } catch (SQLException e) {
            System.out.println(e);
        }
        return user;
    }

    public ArrayList<User> findActiveUsers(String status) {
        ArrayList<User> users = new ArrayList<User>();

        try {
            users = userRepository.getAllActiveUsers(status);
        } catch (SQLException e) {
            System.out.println(e);
        }
        return users;
    }

    public ArrayList<User> findInactiveUsers(String status) {
        ArrayList<User> users = new ArrayList<User>();

        try {
            users = userRepository.getAllInactiveUsers(status);
        } catch (SQLException e) {
            System.out.println(e);
        }
        return users;
    }

    public ArrayList<User> changeStatusActive(String status) {
        ArrayList<User> users = new ArrayList<User>();

        try {
            users = userRepository.updateUserStatusToActive(status);
        } catch (SQLException e) {
            System.out.println(e);
        }
        return users;
    }

    public ArrayList<User> changeStatusInactive(String status) {
        ArrayList<User> users = new ArrayList<User>();

        try {
            users = userRepository.updateUserStatusToInactive(status);
        } catch (SQLException e) {
            System.out.println(e);
        }
        return users;
    }

    public ArrayList<User> removeUser(String status) {
        ArrayList<User> users = new ArrayList<User>();

        try {
            users = userRepository.deleteUser(status);
        } catch (SQLException e) {
            System.out.println(e);
        }
        return users;
    }
}