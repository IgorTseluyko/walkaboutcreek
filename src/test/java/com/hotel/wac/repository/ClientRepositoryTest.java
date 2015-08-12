package com.hotel.wac.repository;

import com.hotel.wac.configuration.Config;
import com.hotel.wac.entity.Client;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.junit.Assert.*;

/**
 * Created by Igor_Tseluiko on 8/12/2015.
 */
@ContextConfiguration(classes = Config.JpaConfiguration.class)
@RunWith(SpringJUnit4ClassRunner.class)
public class ClientRepositoryTest {


    @Before
    public void setUp() throws Exception {
    }


    @After
    public void tearDown() throws Exception {
    }
}