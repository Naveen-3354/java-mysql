import model .UserDetails;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Sample {
    public static Scanner scan;
    public static List<UserDetails> userList;

    public Sample() {
        scan = new Scanner(System.in);
        userList = new ArrayList<>();
    }

    public static UserDetails users;

    public static void main(String[] args) {
        Sample sample = new Sample();
        boolean isOn = true;
        while (isOn) {
            System.out.println("User entries.");
            System.out.println("Enter: [1 to add user, 2 to get all user details, 3 to get specific user detail, 4 to update a user, 5 to delete a specific user, 6 to delete all users, 7 to exit.]");
            int value = scan.nextInt();
            if (value == 1) sample.addUser();
            if (value == 2) sample.getAllUser();
            if (value == 3) sample.getUser();
            if (value == 4) sample.updateUser();
            if (value == 5) sample.deleteUser();
            if (value == 6) sample.deleteAllUser();
            if (value == 7) isOn = false;
            if(value>7 || value <=0) System.out.println("Enter correct no.12");
        }
    }

    public void addUser() {
        System.out.println("Enter user datails.");
        System.out.print("Enter User name :");
        String username = scan.next();
        System.out.print("Enter User email :");
        String email = scan.next();
        System.out.print("Enter User number :");
        String number = scan.next();
        System.out.print("Enter User date of birth :");
        String dateOfBirth = scan.next();
        System.out.print("Enter User password :");
        String password = scan.next();
        users = new UserDetails(username, email, number, dateOfBirth, password);
        userList.add(users);
    }

    public void getAllUser() {
        System.out.println("All users. \n");
        if (userList.isEmpty()) {
            System.out.println("User list is empty.");
        }
        for (UserDetails user : userList) {
            System.out.println("Username  :" + user.getUsername());
            System.out.println("Email     :" + user.getEmail());
            System.out.println("Number    :" + user.getNumber());
            System.out.println("Date of birth :" + user.getDateofbirth());
            System.out.println("Password  :" + user.getPassword() + "\n");
        }
    }

    public void getUser() {
        System.out.print("Enter user name :");
        String name = scan.next();
        boolean userExist= true;
        for (UserDetails user : userList) {
            if (user.getUsername().equals(name)) {
                userExist = false;
                System.out.println("Username  :" + user.getUsername());
                System.out.println("Email     :" + user.getEmail());
                System.out.println("Number    :" + user.getNumber());
                System.out.println("Date of birth :" + user.getDateofbirth());
                System.out.println("Password  :" + user.getPassword() + "\n");
                break;
            }
        }
        if(userExist){
            System.out.println("User does not exist.");
        }
    }

    public void updateUser() {
        System.out.println("Update User.\n");
        System.out.print("Enter user name :");
        String name = scan.next();
        for (UserDetails user : userList) {
            if (user.getUsername().equals(name)) {
                System.out.print("Enter the feild to be updated : [1 for Username, 2 for email, 3 for number, 4 for dateOfBirth, 5 for password] :");
                int feild = scan.nextInt();
                while (feild > 5 || feild <= 0) {
                    System.out.print("Enter correct field no.");
                    feild = scan.nextInt();
                }
                if (feild == 1) {
                    System.out.print("Enter new user name :");
                    String newValue = scan.next();
                    user.setUsername(newValue);
                } else if (feild == 2) {
                    System.out.print("Enter new email :");
                    String newValue = scan.next();
                    user.setEmail(newValue);
                } else if (feild == 3) {
                    System.out.print("Enter new Number :");
                    String newValue = scan.next();
                    user.setNumber(newValue);
                } else if (feild == 4) {
                    System.out.print("Enter new date of birth :");
                    String newValue = scan.next();
                    user.setDateofbirth(newValue);
                } else {
                    System.out.print("Enter new password :");
                    String newValue = scan.next();
                    user.setPassword(newValue);
                }


                user.setUsername(name);
                System.out.println("After update :");
                System.out.println("Username  :" + user.getUsername());
                System.out.println("Email     :" + user.getEmail());
                System.out.println("Number    :" + user.getNumber());
                System.out.println("Date of birth :" + user.getDateofbirth());
                System.out.println("Password  :" + user.getPassword());
                System.out.println("User added. \n");

            }
        }
    }

    public void deleteUser() {
        System.out.println("Delete user form the List.");
        System.out.print("Enter user name");
        String deleteName = scan.next();
        for (UserDetails user : userList) {
            if (user.getUsername().equals(deleteName)) {
                userList.remove(user);
                break;
            }
        }
        System.out.println("User deleted form the List.");
    }

    public void deleteAllUser() {
        userList.clear();
        System.out.println("All users are deleted.");
    }
}
