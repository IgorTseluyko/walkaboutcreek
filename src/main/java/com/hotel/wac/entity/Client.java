package com.hotel.wac.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

/**
 * Created by Igor_Tseluiko on 8/12/2015.
 */
@Entity
@Table(name = "client")
public class Client {

    @Id
    @Column(name = "id")
    private long id;

    @Column(name = "name")
    private String name;

    @Column(name = "phone")
    private String phone;

    @Column(name = "date_of_last_visit")
    private Date dateOfLastVisit;

    @Column(name = "money_spent")
    private long moneySpent;

    @Column(name = "transport_type")
    private String transportType;

    @Column(name = "description")
    private String description;

    public Client() {
    }

    public Client(String name, String phone) {
        this.name = name;
        this.phone = phone;
    }

    public Client(long id, String phone) {
        this.id = id;
        this.phone = phone;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
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

    @Override
    public String toString() {
        return "Client{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", phone='" + phone + '\'' +
                ", dateOfLastVisit=" + dateOfLastVisit +
                ", moneySpent=" + moneySpent +
                ", transportType='" + transportType + '\'' +
                ", description='" + description + '\'' +
                '}';
    }

}
