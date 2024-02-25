import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class SqlConnection {
    public static void main(String[] args) {
        String url = "jdbc:mysql://127.0.0.1:3306/login_schema";
        String username = "root";
        String password = "root";
        String query = "select *from users";

        try {

            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = connection(url, username, password);
            System.out.println("Connection Established successfully");
            Statement st = statement(con);
            ResultSet rs =result(st,query);
            rs.next();

            System.out.println(rs);
            String name = rs.getString("userName");

            System.out.println(name);
            st.close();
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

    static Statement statement(Connection con) throws Exception {
        return con.createStatement();
    }

    static ResultSet result (Statement st, String query) throws Exception{
        return st.executeQuery(query);
    }
}
