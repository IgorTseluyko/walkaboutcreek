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

import java.util.Date;

import static org.junit.Assert.assertEquals;

/**
 * Created by Igor_Tseluiko on 8/12/2015.
 */
@ContextConfiguration(classes = Config.JpaConfiguration.class)
@RunWith(SpringJUnit4ClassRunner.class)
public class ClientRepositoryTest {

    private static final Logger LOG = LoggerFactory.getLogger(ClientRepositoryTest.class);
    @Autowired
    private ClientRepository clientRepository;

    @Before
    public void setUp() throws Exception {
        Client client = new Client("igor@epam.com", "0501810453");
        client.setName("igor");
        clientRepository.save(client);
    }

    @Test
    public void testSave() {
        LOG.info(clientRepository.findByName("igor").toString());
        assertEquals(1, clientRepository.count());

    }


    @After
    public void tearDown() throws Exception {
        clientRepository.deleteAll();
    }
}