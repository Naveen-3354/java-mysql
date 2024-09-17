import java.util.Objects;

public class Users {

    private String username;
    private String email;
    private String number;
    private String dateofbirth;
    private String password;

    public Users(String username, String email, String number, String dateofbirth, String password) {
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



    @Override
    public int hashCode() {
        return Objects.hash(username, email, number, dateofbirth, password);
    }
}
