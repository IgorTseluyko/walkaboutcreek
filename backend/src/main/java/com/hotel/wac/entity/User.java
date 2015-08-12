package com.hotel.wac.entity;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by Igor_Tseluiko on 8/12/2015.
 */
@Entity
@Table(name = "user")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private long id;

    @Column(name = "email", nullable = false, unique = true)
    private String email;

    @Column(name = "password", nullable = false)
    private String password;

    @Column(name = "last_login")
    private Date lastLogin;

    @Column(name = "last_password_change")
    private Date lastPasswordChange;


    public User(String email, String password) {
        this.email = email;
        this.password = password;
    }

    public User() {
    }

    public long getId() {
        return id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Date getLastLogin() {
        return (Date) lastLogin.clone();
    }

    public void setLastLogin(Date lastLogin) {
        this.lastLogin = (Date) lastLogin.clone();
    }

    public Date getLastPasswordChange() {
        return (Date) lastPasswordChange.clone();
    }

    public void setLastPasswordChange(Date lastPasswordChange) {
        this.lastPasswordChange = (Date) lastPasswordChange.clone();
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", lastLogin=" + lastLogin +
                ", lastPasswordChange=" + lastPasswordChange +
                '}';
    }

}
