package com.hotel.wac.entity;

import org.springframework.data.mongodb.core.mapping.Document;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Date;

/**
 * Created by mariiarudenko on 8/13/15.
 */
@Document(collection = "price")
public class Price {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private String id;
    
    private double roomPrice;
    
    private int roomId;
    
    private Date periodFrom;
    
    private Date periodTo; 
    
}
