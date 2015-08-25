package com.hotel.wac.service;

import com.hotel.wac.entity.Client;
import com.hotel.wac.repository.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

/**
 * Created by Igor_Tseluiko on 8/12/2015.
 */
@Service
public class AuthenticationService implements Authentication {

    @Autowired
    private ClientRepository clientRepository;

    @Override
    public void register(String email, String password) {
        Client client = new Client(email, password);

        clientRepository.save(client);
    }

    @Override
    public String login(String email, String password) {
        return null;
    }

    @Override
    public String logout(String token) {
        return null;
    }

    @Override
    public void recoverPassword(String email, String newPassword) {

    }
}
