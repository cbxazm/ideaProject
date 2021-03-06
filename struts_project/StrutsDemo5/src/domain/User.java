package domain;

import java.util.Date;

public class User {
    private String username;
    private String password;
    private Date birthday;
    private String hobby;
    private String married;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public String getHobby() {
        return hobby;
    }

    public void setHobby(String hobby) {
        this.hobby = hobby;
    }


    public String getMarried() {
        return married;
    }

    public void setMarried(String married) {
        this.married = married;
    }

    @Override
    public String toString() {
        return "User{" +
                "username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", birthday=" + birthday +
                ", hobby='" + hobby + '\'' +
                ", married='" + married + '\'' +
                '}';
    }
}
