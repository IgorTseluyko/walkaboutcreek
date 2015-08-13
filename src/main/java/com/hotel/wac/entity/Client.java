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
    private String name;

    @Indexed(unique = true)
    private String phone;

    @Indexed(unique = true)
    private String email;

    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
    private Date dateOfLastVisit;

    private String token;

    private long moneySpent;

    private String transportType;

    private String description;

    private String password;

    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
    private Date lastLogin;

    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
    private Date lastPasswordChange;

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

    public Date getDateOfLastVisit() {
        return dateOfLastVisit;
    }

    public void setDateOfLastVisit(Date dateOfLastVisit) {
        this.dateOfLastVisit = dateOfLastVisit;
    }

    public long getMoneySpent() {
        return moneySpent;
    }

    public void setMoneySpent(long moneySpent) {
        this.moneySpent = moneySpent;
    }

    public String getTransportType() {
        return transportType;
    }

    public void setTransportType(String transportType) {
        this.transportType = transportType;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
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
        return lastLogin;
    }

    public void setLastLogin(Date lastLogin) {
        this.lastLogin = lastLogin;
    }

    public Date getLastPasswordChange() {
        return lastPasswordChange;
    }

    public void setLastPasswordChange(Date lastPasswordChange) {
        this.lastPasswordChange = lastPasswordChange;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    @Override
    public String toString() {
        return "Client{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", phone='" + phone + '\'' +
                ", email='" + email + '\'' +
                ", dateOfLastVisit=" + dateOfLastVisit +
                ", token='" + token + '\'' +
                ", moneySpent=" + moneySpent +
                ", transportType='" + transportType + '\'' +
                ", description='" + description + '\'' +
                ", password='" + password + '\'' +
                ", lastLogin=" + lastLogin +
                ", lastPasswordChange=" + lastPasswordChange +
                '}';
    }

}
