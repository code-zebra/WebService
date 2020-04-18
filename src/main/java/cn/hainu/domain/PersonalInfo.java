package cn.hainu.domain;

import java.io.Serializable;

/**
 * @author Ant
 */
public class PersonalInfo implements Serializable {
    private String username;
    private int money;
    private String name;
    private String phone;
    private String email;

    @Override
    public String toString() {
        return "PersonalInfo{" +
                "username='" + username + '\'' +
                ", money=" + money +
                ", name='" + name + '\'' +
                ", phone='" + phone + '\'' +
                ", email='" + email + '\'' +
                '}';
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public int getMoney() {
        return money;
    }

    public void setMoney(int money) {
        this.money = money;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
