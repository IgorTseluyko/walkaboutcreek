package com.hotel.wac.entity;

import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Date;

/**
 * Created by Igor_Tseluiko on 8/12/2015.
 */
@Document(collection = "clients")
public class Client {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private String id;

    @Indexed(unique = true)
    private String phone;

    @Indexed(unique = true)
    private String email;

    private String name;

    private String token;

    private long moneySpent;

    private String password;
    
    private String userType;
    
    private int discount;

    public Client() {
    }

    public Client(String email, String password) {
        this.email = email;
        this.password = password;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
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

    public long getMoneySpent() {
        return moneySpent;
    }

    public void setMoneySpent(long moneySpent) {
        this.moneySpent = moneySpent;
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

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String getUserType() {
        return userType;
    }

    public void setUserType(String userType) {
        this.userType = userType;
    }

    public int getDiscount() {
        return discount;
    }

    public void setDiscount(int discount) {
        this.discount = discount;
    }

    @Override
    public String toString() {
        return "Client{" +
                "id='" + id + '\'' +
                ", phone='" + phone + '\'' +
                ", email='" + email + '\'' +
                ", name='" + name + '\'' +
                ", token='" + token + '\'' +
                ", moneySpent=" + moneySpent +
                ", password='" + password + '\'' +
                ", userType='" + userType + '\'' +
                ", discount=" + discount +
                '}';
    }

}
