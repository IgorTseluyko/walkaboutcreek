package com.hotel.wac.repository;

import com.hotel.wac.entity.Booking;
import org.springframework.data.mongodb.repository.MongoRepository;

/**
 * Created by Igor_Tseluiko on 8/12/2015.
 * Spring-Data repository for table "hotel"
 */
public interface BookingRepository extends MongoRepository<Booking, Integer> {
}
