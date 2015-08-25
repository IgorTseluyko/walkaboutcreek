package com.hotel.wac.entity;

import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.Id;
import java.util.Date;

/**
 * Created by Igor_Tseluiko on 8/12/2015.
 */
@Document(collection = "booking")
public class Booking {

    @Id
    @Indexed(unique = true)
    private int roomId;

    @Indexed(unique = true)
    private String clientId;

    @Indexed
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
    private Date startDate;

    @Indexed
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
    private Date endDate;

    @Indexed
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
    private Date arrivalDateTime;
    
    private String transfer;
    
    private int persons;
    
    private String bookingSource;

    private double totalPrice;

    public Booking() {
    }

    public long getRoomId() {
        return roomId;
    }

    public void setRoomId(int roomId) {
        this.roomId = roomId;
    }

    public String getClientId() {
        return clientId;
    }

    public void setClientId(String clientId) {
        this.clientId = clientId;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public Date getArrivalDateTime() {
        return arrivalDateTime;
    }

    public void setArrivalDateTime(Date arrivalDateTime) {
        this.arrivalDateTime = arrivalDateTime;
    }

    public String getTransfer() {
        return transfer;
    }

    public void setTransfer(String transfer) {
        this.transfer = transfer;
    }

    public int getPersons() {
        return persons;
    }

    public void setPersons(int persons) {
        this.persons = persons;
    }

    public String getBookingSource() {
        return bookingSource;
    }

    public void setBookingSource(String bookingSource) {
        this.bookingSource = bookingSource;
    }

    public double getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(double totalPrice) {
        this.totalPrice = totalPrice;
    }

    @Override
    public String toString() {
        return "Booking{" +
                "roomId=" + roomId +
                ", clientId='" + clientId + '\'' +
                ", startDate=" + startDate +
                ", endDate=" + endDate +
                ", arrivalDateTime=" + arrivalDateTime +
                ", transfer='" + transfer + '\'' +
                ", persons=" + persons +
                ", bookingSource='" + bookingSource + '\'' +
                ", totalPrice=" + totalPrice +
                '}';
    }
}
