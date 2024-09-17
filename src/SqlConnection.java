 import java.sql.*;
 import java.util.Scanner;

 public class SqlConnection {

    final String url = "jdbc:mysql://localhost:3306";
    static Scanner scan  = new Scanner(System.in);

    public static void main(String[] args) {

        SqlConnection sql = new SqlConnection();
        try (Connection con = connection(sql.url)) {
            System.out.println("Database connected....");
            boolean isStart = true;

            while(isStart){
                System.out.print("Main menu: \n1.Create database. " +
                        "\n2.View database. \n3.Select database.");
                int num = scan.nextInt();
                switch(num){
                    case 1:
                        createDatabase(con);
                        break;
                    case 2:
                        viewDatabase(con);
                        break;
                    case 3:
                        isStart = false;
                }
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
    static Connection connection(String url) throws Exception {
        System.out.print("Enter user name :");
        String username = scan.next();
        System.out.println("Enter password :");
        String password = scan.next();
        return DriverManager.getConnection(url, username, password);
    }

    static void createDatabase(Connection con) throws SQLException {
        PreparedStatement statement = con.prepareStatement("create schema "+scan.next());
        statement.execute();
    }

    static void viewDatabase(Connection con)throws SQLException{
        PreparedStatement statement = con.prepareStatement("show databases;");
        ResultSet resultSet = statement.executeQuery();
        while(resultSet.next()){
            System.out.println(resultSet.getString("database"));
        }
    }

    static void createRecord(Connection con) {
        String sql = "INSERT INTO users (userId, userName, password) VALUES (?, ?, ?)";
        try (PreparedStatement statement = con.prepareStatement(sql);) {
            statement.setInt(1, 12);
            statement.setString(2, "value2");
            statement.setString(3, "Naveenqeqw");
            statement.executeUpdate();
            System.out.println("Record created.");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    static void readRecord(Connection con) {
        try {
            String sql = "SELECT userId, userName, password FROM users WHERE userId = ?";
            PreparedStatement statement = con.prepareStatement(sql);
            statement.setInt(1, 12 );
            ResultSet result = statement.executeQuery();
            if (result.next()) {
                int column1 = result.getInt("userId");
                String column2 = result.getString("userName");
                String column3 = result.getString("password");
                System.out.println("UserId: " + column1);
                System.out.println("Username: " + column2);
                System.out.println("Password: " + column3);
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    static void updateRecord(Connection con) {
        try {
            String sql = "UPDATE users SET userId = ?, userName = ?, password = ? WHERE userId = ?";
            PreparedStatement statement = con.prepareStatement(sql);
            statement.setInt(1, 1);
            statement.setString(2, "Naveen");
            statement.setString(3, "Naveen@123");
            statement.setInt(4, 3);
            statement.executeUpdate();
            System.out.println("Record updated.");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    static void deleteRecord(Connection con) {
        try {
            String sql = "DELETE FROM users WHERE userId = ?";
            PreparedStatement statement = con.prepareStatement(sql);
            statement.setInt(1, 1);
            statement.executeUpdate();
            System.out.println("Record deleted.");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

    }


}
