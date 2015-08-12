package com.hotel.wac.entity;

import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.Id;
import java.util.Date;

/**
 * Created by Igor_Tseluiko on 8/12/2015.
 */
@Document(collection = "hotels")
public class Hotel {

    @Id
    @Indexed(unique = true)
    private long roomId;

    @Indexed(unique = true)
    private String clientId;

    @Indexed
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
    private Date startDate;

    @Indexed
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
    private Date endDate;

    private long roomPrice;

    private long hotelId;

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
