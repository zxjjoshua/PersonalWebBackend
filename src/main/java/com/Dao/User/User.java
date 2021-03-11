package com.Dao.User;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;


@Entity
@Data
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String gender;

    private String username;

    private String email;

    private String passwd;

    public int getId() {
        return id;
    }

    public String getUsername() {
        return username;
    }

    public String getEmail() {
        return email;
    }

    public String getGender() {
        return gender;
    }

    public String getPasswd() {
        return passwd;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", gender='" + gender + '\'' +
                ", username='" + username + '\'' +
                ", email='" + email + '\'' +
                ", passwd='" + passwd + '\'' +
                '}';
    }
}
