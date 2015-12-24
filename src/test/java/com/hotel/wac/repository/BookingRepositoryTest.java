package com.hotel.wac.repository;

import com.hotel.wac.configuration.Config;
import com.hotel.wac.entity.Booking;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.util.Date;

import static org.junit.Assert.assertEquals;

/**
 * Created by Igor_Tseluiko on 8/12/2015.
 */
@ContextConfiguration(classes = Config.JpaConfiguration.class)
@RunWith(SpringJUnit4ClassRunner.class)
public class BookingRepositoryTest {

    private static final Logger LOG = LoggerFactory.getLogger(BookingRepositoryTest.class);

    @Autowired
    private BookingRepository bookingRepository;

    @Before
    public void setUp() throws Exception {
        Booking hotel = new Booking();
        hotel.setClientId("asd123");
        hotel.setRoomId(1);

        Instant instantEnd = LocalDateTime.now().plusDays(4).toInstant(ZoneOffset.UTC);
        Instant instantStart= LocalDateTime.now().minusDays(4).toInstant(ZoneOffset.UTC);

        hotel.setStartDate(Date.from(instantStart));
        hotel.setEndDate(Date.from(instantEnd));

        LOG.info("hotel1: {}", hotel);
        bookingRepository.save(hotel);

        Booking hotel2 = new Booking();
        hotel2.setClientId("asd123567");
        hotel2.setRoomId(2);

        Instant instantEnd2 = LocalDateTime.now().plusDays(1).toInstant(ZoneOffset.UTC);
        Instant instantStart2= LocalDateTime.now().minusDays(1).toInstant(ZoneOffset.UTC);

        hotel2.setStartDate(Date.from(instantStart2));
        hotel2.setEndDate(Date.from(instantEnd2));

        LOG.info("hotel2: {}", hotel2);
        bookingRepository.save(hotel2);


        Booking hotel3 = new Booking();
        hotel3.setRoomId(3);

        bookingRepository.save(hotel3);
        LOG.info("hotel3: {}", hotel3);
    }

    @Test
    public void testDateRange(){
        Instant instantStart= LocalDateTime.now().plusDays(2).toInstant(ZoneOffset.UTC);
        Instant instantEnd = LocalDateTime.now().plusDays(4).toInstant(ZoneOffset.UTC);

        bookingRepository
                .findByStartDateAfterAndEndDateBefore(Date.from(instantStart), Date.from(instantEnd))
                .forEach(b -> LOG.info(b.toString()));
    }


//    @Test
//    public void testSave() {
//        assertEquals(1, bookingRepository.count());
//    }

    @After
    public void tearDown() throws Exception {
        bookingRepository.deleteAll();
    }
}