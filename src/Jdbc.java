import java.sql.*;
import java.util.Scanner;

public class Jdbc {
    static Scanner scan = new Scanner(System.in);

    public static void main(String[] args) {
        Jdbc jdbc = new Jdbc();
        try (Connection connection = jdbc.createConnection()) {
            System.out.println("Database connected successfully...");
            boolean isStart = true;
            while (isStart) {
                System.out.println("\nMain Menu: \n1. Create database. \n2.View database. \n3.Delete database. \n4.Select database. \n5.Exit.");
                int num = scan.nextInt();
                switch (num) {
                    case 1:
                        jdbc.createDatabase(connection);
                        break;
                    case 2:
                        jdbc.viewDatabase(connection);
                        break;
                    case 3:
                        jdbc.deletaDatabase(connection);
                        break;
                    case 4:
                        jdbc.selectDatabase(connection);
                        break;
                    case 5:
                        isStart = false;
                        break;
                    default:
                        System.out.println("Enter correct number...");
                }
            }
        } catch (SQLException exception) {
            System.out.println(exception.getMessage());
        }
    }

    public Connection createConnection() throws SQLException {
        System.out.print("Enter username: ");
        String username = scan.next();
        System.out.print("Enter Password :");
        String password = scan.next();
        return DriverManager.getConnection("jdbc:mysql://localhost:3306", username, password);
    }

    public void createDatabase(Connection connection) throws SQLException {
        System.out.print("Enter database name:");
        PreparedStatement statement = connection.prepareStatement("create schema " + scan.next());
        statement.execute();
        System.out.println("Database created.");
    }

    public void viewDatabase(Connection connection) throws SQLException {
        PreparedStatement statement = connection.prepareStatement("show databases;");
        ResultSet resultSet = statement.executeQuery();
        while (resultSet.next()) {
            System.out.println(resultSet.getString("database"));
        }
    }

    public void deletaDatabase(Connection connection) throws SQLException {
        System.out.print("Enter database name:");
        PreparedStatement statement = connection.prepareStatement("drop database " + scan.next());
        statement.execute();
        System.out.println("Database deleted...");
    }

    public void selectDatabase(Connection connection) throws SQLException{
        System.out.print("Enter database name:");
        PreparedStatement statement = connection.prepareStatement("use " + scan.next());
        statement.execute();
        System.out.println("Database selected...");

    }
}
