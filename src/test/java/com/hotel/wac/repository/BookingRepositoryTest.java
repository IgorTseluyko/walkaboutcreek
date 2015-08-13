package com.hotel.wac.repository;

import com.hotel.wac.configuration.Config;
import com.hotel.wac.entity.Booking;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.junit.Assert.assertEquals;

/**
 * Created by Igor_Tseluiko on 8/12/2015.
 */
@ContextConfiguration(classes = Config.JpaConfiguration.class)
@RunWith(SpringJUnit4ClassRunner.class)
public class BookingRepositoryTest {

    @Autowired
    private BookingRepository bookingRepository;

    @Before
    public void setUp() throws Exception {
        Booking hotel = new Booking();
        hotel.setClientId("asd123");
        bookingRepository.save(hotel);
    }

    @Test
    public void testSave() {
        assertEquals(1, bookingRepository.count());
    }

    @After
    public void tearDown() throws Exception {
        bookingRepository.deleteAll();
    }
}