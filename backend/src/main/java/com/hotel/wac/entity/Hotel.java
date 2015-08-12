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
@Table(name = "hotel")
public class Hotel {

    @Id
    @Column(name = "room_id")
    private long roomId;

    @Column(name = "hotel_id")
    private long hotelId;

    @Column(name = "client_id")
    private long clientId;

    @Column(name = "start_date")
    private Date startDate;

    @Column(name = "end_date")
    private Date endDate;

    @Column(name = "room_price")
    private long roomPrice;

    public Hotel() {
    }

    public long getRoomId() {
        return roomId;
    }

    public void setRoomId(long roomId) {
        this.roomId = roomId;
    }

    public long getHotelId() {
        return hotelId;
    }

    public void setHotelId(long hotelId) {
        this.hotelId = hotelId;
    }

    public long getClientId() {
        return clientId;
    }

    public void setClientId(long clientId) {
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

    public long getRoomPrice() {
        return roomPrice;
    }

    public void setRoomPrice(long roomPrice) {
        this.roomPrice = roomPrice;
    }

    @Override
    public String toString() {
        return "Hotel{" +
                "roomId=" + roomId +
                ", hotelId=" + hotelId +
                ", clientId=" + clientId +
                ", startDate=" + startDate +
                ", endDate=" + endDate +
                ", roomPrice=" + roomPrice +
                '}';
    }
}
