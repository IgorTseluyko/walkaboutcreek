package com.hotel.wac.controller;

import com.hotel.wac.configuration.Config;
import com.hotel.wac.repository.ClientRepository;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

/**
 * Created by Igor_Tseluiko on 8/12/2015.
 */
@ContextConfiguration(classes = {
        Config.JpaConfiguration.class,
        Config.WebConfiguration.class,
        Config.class
})
@WebAppConfiguration
@RunWith(SpringJUnit4ClassRunner.class)
public class AuthenticationControllerTest {

    @Autowired
    private ClientRepository repository;

    @Autowired
    private WebApplicationContext appContext;

    private MockMvc mockMvc;

    @Before
    public void setUp() throws Exception {
        mockMvc = MockMvcBuilders.
                webAppContextSetup(appContext).
                build();
    }

    @After
    public void tearDown() throws Exception {
        repository.deleteAll();
    }

    @Test
    public void testRegister() throws Exception {
        mockMvc.perform(get("/auth/reg?email=masha.krasivaya@gail.com&password=123456"))
                .andExpect(status().isOk());
    }
}