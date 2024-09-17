
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Sample {
    public static Scanner scan;
    public static List<Users> userList;
    public static Users users;

    public Sample() {
        scan = new Scanner(System.in);
        userList = new ArrayList<>();
    }
    
    public static void main(String... args) {
        Sample sample = new Sample();
        var isOn = true;
        while (isOn) {
            System.out.println("MAIN MENU:");
            System.out.println("1 to add user.\n2 to get all user details.\n3 to get specific user detail.\n4 to update a user.\n5 to delete a specific user.\n6 to delete all users.\n7 to exit.");
            int value = scan.nextInt();
            switch (value) {
                case 1:
                    sample.addUser();
                    break;
                case 2:
                    sample.getAllUser();
                    break;
                case 3:
                    sample.getUser();
                    break;
                case 4:
                    sample.updateUser();
                    break;
                case 5:
                    sample.deleteUser();
                    break;
                case 6:
                    sample.deleteAllUser();
                    break;
                case 7:
                    isOn = false;
                    break;
                default:
                    System.out.println("Enter correct no.");
            }
        }
    }




    public void addUser() {
        System.out.println("Enter user details.");
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
        users = new Users(username, email, number, dateOfBirth, password);
        userList.add(users);
        System.out.print("User added.");
    }

    public void getAllUser() {
        System.out.println("All users. \n");
        if (userList.isEmpty()) {
            System.out.println("User list is empty.\n");
            System.out.flush();
        }
        for (Users user : userList) {
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
        boolean userExist = true;
        for (Users user : userList) {
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
        if (userExist) {
            System.out.println("User does not exist.\n");
        }
    }

    public void updateUser() {
        System.out.println("Update User.\n");
        System.out.print("Enter user name :");
        String name = scan.next();
        for (Users user : userList) {
            if (user.getUsername().equals(name)) {
                System.out.print("Enter the field to be updated : [1 for Username, 2 for email, 3 for number, 4 for dateOfBirth, 5 for password] :");
                int field = scan.nextInt();
                String newValue;
                while (field > 5 || field <= 0) {
                    System.out.print("Enter correct field no.");
                    field = scan.nextInt();
                }

                switch (field) {
                    case 1:
                        System.out.print("Enter new user name :");
                        newValue = scan.next();
                        user.setUsername(newValue);
                        break;
                    case 2:
                        System.out.print("Enter new email :");
                        newValue = scan.next();
                        user.setEmail(newValue);
                        break;
                    case 3:
                        System.out.print("Enter new Number :");
                        newValue = scan.next();
                        user.setNumber(newValue);
                        break;
                    case 4:
                        System.out.print("Enter new date of birth :");
                        newValue = scan.next();
                        user.setDateofbirth(newValue);
                        break;
                    case 5:
                        System.out.print("Enter new password :");
                        newValue = scan.next();
                        user.setPassword(newValue);
                        break;


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
        for (Users user : userList) {
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

class UserDetails {

    private String username;
    private String email;
    private String number;
    private String dateofbirth;
    private String password;

    public UserDetails(String username, String email, String number, String dateofbirth, String password) {
        this.username = username;
        this.email = email;
        this.number = number;
        this.dateofbirth = dateofbirth;
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getDateofbirth() {
        return dateofbirth;
    }

    public void setDateofbirth(String dateofbirth) {
        this.dateofbirth = dateofbirth;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

}
