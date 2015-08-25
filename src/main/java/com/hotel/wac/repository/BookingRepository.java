package com.hotel.wac.repository;

import com.hotel.wac.entity.Booking;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Date;
import java.util.List;

/**
 * Created by Igor_Tseluiko on 8/12/2015.
 * Spring-Data repository for table "hotel"
 */
public interface BookingRepository extends MongoRepository<Booking, Integer> {

    List<Booking> findByStartDateAfterAndEndDateBefore(Date startDate, Date endDate);

}
