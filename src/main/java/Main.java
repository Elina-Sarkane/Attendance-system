import user.User;
import user.UserController;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    Scanner scanner = new Scanner(System.in);
    UserController userController = new UserController();

    public static void main(String[] args) {
        Main main = new Main();
        main.showMenu();
    }

        void showMenu(){
            String userInput = "";
            do {
                System.out.println("Welcome to attendance system!");
                System.out.println("1. Log in");
                System.out.println("2. Add new user");
                System.out.println("3. Search user");
                System.out.println("4. Update user");
                System.out.println("5. Delete user");
                System.out.println("6. Exit");

                System.out.print("\nEnter your choice:");
                userInput = scanner.nextLine();

                switch (userInput){
                    case "1":
                       // logIn();
                        break;
                    case "2":
                        userCreating();
                        break;
                    case "3":
                        searchUser();
                        break;
                    case "4":
                        updateUser();
                        break;
                    case "5":
                        deleteUser();
                        break;
                    case "6":
                        System.out.println("Exiting attendance system!");
                        break;
                    default:
                        break;

                }
                System.out.println("Press 0 to continue\n");
                scanner.nextLine();

            }while (!userInput.equalsIgnoreCase("6"));

            //return;
        }

       /* void logIn(){
        User user = new User();
            System.out.println("Log in");

            System.out.println("Enter name: ");
            user.name = scanner.nextLine();
            System.out.println("Enter email: ");
            user.email = scanner.nextLine();
        }*/
        void userCreating(){

        User newUser = new User();
        System.out.println("Create new user");

        System.out.println("Enter user name: ");
        newUser.name = scanner.nextLine();
        System.out.println("Enter email: ");
        newUser.email = scanner.nextLine();
        System.out.println("Enter user status: ");
        newUser.status = scanner.nextLine();


        System.out.println(userController.createUser(newUser));

        }

        void searchUser() {
        System.out.println("\nSearch users by status: ");
        String userInput = scanner.nextLine();
    //active user
        if (userInput.equalsIgnoreCase("active")) {
            ArrayList<User> users = userController.findActiveUsers(scanner.nextLine());
            System.out.println(users.size() + " active users found");
            for (User currentUser : users) {
                System.out.println(currentUser.name + " - " + currentUser.status + " - " + currentUser.last_updated);
            }
            //User user = userController.findUsers(1);
           // System.out.println("Active users found!");
        } else {
    //inactive user
            ArrayList<User> users = userController.findInactiveUsers(scanner.nextLine());
            System.out.println(users.size() + " inactive users found");
            for (User currentUser : users) {
                System.out.println(currentUser.name + " - " + currentUser.status + " - " + currentUser.last_updated);
            }
           // User user1 = userController.findUsers(1);
           // System.out.println("Inactive users found!");
        }
    }

    void updateUser(){
        System.out.println("Which users you want to update?");
        String userInput = scanner.nextLine();
        if(userInput.equalsIgnoreCase("active")) {
            ArrayList<User> users = userController.changeStatusActive(scanner.nextLine());
            System.out.println(users.size() + " active users found!");
            for (User currentUser : users) {
                System.out.println(currentUser.name + " - " + currentUser.status + " - " + currentUser.last_updated);
            }
            //ArrayList<User> users1 = userController.changeStatusActive(scanner.nextLine());
            //System.out.println("Active users changed to inactive successfully!");
        }else {
            ArrayList<User> users = userController.changeStatusInactive(scanner.nextLine());
            System.out.println(users.size() + " inactive users found");
            for (User currentUser : users) {
                System.out.println(currentUser.name + " - " + currentUser.status + " - " + currentUser.last_updated);
            }
           // userController.changeStatusInactive(scanner.nextLine());
           // System.out.println("Inactive users changed to active successfully!");
        }
    }
    void deleteUser(){
            User user = new User();
        System.out.println("Enter user status which you want to remove: ");
        user.status = scanner.nextLine();

        System.out.println(userController.removeUser(user.status));
    }
}

