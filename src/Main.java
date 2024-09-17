import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Main {
    public static void main(String[] args){
        String url = "jdbc:mysql://localhost:3306/new_schema12354";
        String username = "root";
        String password = "root";
        Main main = new Main();
        try(Connection con = DriverManager.getConnection(url,username,password)){
            System.out.println("Database Connected.");
            main.createDatabase(con);

        }catch (SQLException ex){
            System.out.println(ex.getMessage());
        }
    }

    void createDatabase(Connection con) throws SQLException {
        String sql = "create table if not exists users(id int primary key, name varchar(45), email varchar(45))";
        PreparedStatement statement = con.prepareStatement(sql);
        statement.execute();
        System.out.println("Table created.");
    }
}