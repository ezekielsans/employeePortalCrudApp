package com.crudapp.restfulcrud.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "users")
/*
 * using lombook annootations
 * 
 * @NoArgsConstructor
 * 
 * @AllArgsConstructor
 * 
 * @Getter
 * 
 * @Setter
 * 
 * @ToString
 * 
 */

// without lombok approach
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer userId;
    private String username;
    private String last_name;
    private String first_name;
    private String password;
    private String email;
    private String phonenumber;

    // noArgs constructor
    public User() {
    }

    // constructors

    public User(Integer userId, String username, String last_name, String first_name, String password, String email,
            String phonenumber) {
        this.userId = userId;
        this.username = username;
        this.last_name = last_name;
        this.first_name = first_name;
        this.password = password;
        this.email = email;
        this.phonenumber = phonenumber;
    }

    // getter and setters

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getLast_name() {
        return last_name;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }

    public String getFirst_name() {
        return first_name;
    }

    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhonenumber() {
        return phonenumber;
    }

    public void setPhonenumber(String phonenumber) {
        this.phonenumber = phonenumber;
    }

    @Override
    public String toString() {
        return "User [userId=" + userId + ", username=" + username + ", last_name=" + last_name + ", first_name="
                + first_name + ", password=" + password + ", email=" + email + ", phonenumber=" + phonenumber + "]";
    }

}
