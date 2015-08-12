package com.hotel.wac.repository;

import com.hotel.wac.configuration.Config;
import com.hotel.wac.entity.User;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * Created by Igor_Tseluiko on 8/12/2015.
 */
@ContextConfiguration(classes = Config.JpaConfiguration.class)
@RunWith(SpringJUnit4ClassRunner.class)
public class UserRepositoryTest{

    @Autowired
    private UserRepository userRepository;

    private static final Logger LOG = LoggerFactory.getLogger(UserRepositoryTest.class);

    @Before
    public void setUp() throws Exception {
        User user = new User("igor.123@gmail.com", "123456");
        userRepository.save(user);
    }

    @Test
    public void test(){
        LOG.info(userRepository.findAll().toString());
    }

    @After
    public void tearDown() throws Exception {
        userRepository.deleteAll();
    }
}