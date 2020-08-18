package LoginPackage;

import java.util.Objects;

public class UserLogin {
    private String Username;
    private String Password;
    private boolean isAdmin;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UserLogin userLogin = (UserLogin) o;
        return isAdmin == userLogin.isAdmin &&
                Objects.equals(Username, userLogin.Username) &&
                Objects.equals(Password, userLogin.Password);
    }

    @Override
    public int hashCode() {
        return Objects.hash(Username, Password, isAdmin);
    }

    public UserLogin(String username, String password, boolean isAdmin) {
        Username = username;
        Password = password;
        this.isAdmin = isAdmin;
    }

    public String getUsername() {
        return Username;
    }

    public void setUsername(String username) {
        Username = username;
    }

    public String getPassword() {
        return Password;
    }

    public void setPassword(String password) {
        Password = password;
    }

    public boolean isAdmin() {
        return isAdmin;
    }

    public void setAdmin(boolean admin) {
        isAdmin = admin;
    }


    @Override
    public String toString() {
        return "User{" +
                "Username='" + Username + '\'' +
                ", Password='" + Password + '\'' +
                ", isAdmin=" + isAdmin +
                '}';
    }
}
