import java.sql.*;

public class SqlConnection {
    public static void main(String[] args) {
        String url = "jdbc:mysql://127.0.0.1:3306/login_schema";
        String username = "root";
        String password = "root";

        try {

            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = connection(url, username, password);
            System.out.println("Connection Established successfully");
            createRecord(con);
            readRecord(con);
            updateRecord(con);
            deleteRecord(con);
            con.close();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        } finally {
            System.out.println("Connection Closed....");

        }
    }

    static Connection connection(String url, String username, String password) throws Exception {
        return DriverManager.getConnection(url, username, password);
    }


    static void createRecord(Connection con){
        try {
            String sql = "INSERT INTO users (userId, userName, password) VALUES (?, ?, ?)";
            PreparedStatement statement = con.prepareStatement(sql);
            statement.setInt(1, 3);
            statement.setString(2, "value2");
            statement.setString(3, "Naveenqeqw");
            statement.executeUpdate();
            System.out.println("Record created.");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    static void readRecord(Connection con){

        try {
            String sql = "SELECT userId, userName, password FROM users WHERE userId = ?";
            PreparedStatement statement = con.prepareStatement(sql);
            statement.setInt(1, 3);
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

    static void updateRecord(Connection con){

        try {
            String sql = "UPDATE users SET userId = ?, userName = ?, password = ? WHERE userId = ?";
            PreparedStatement statement = con.prepareStatement(sql);
            statement.setInt(1, 3);
            statement.setString(2, "new_value2");
            statement.setString(3, "Qwerty");
            statement.setInt(4, 3);
            statement.executeUpdate();
            System.out.println("Record updated.");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    static void deleteRecord(Connection con){
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
