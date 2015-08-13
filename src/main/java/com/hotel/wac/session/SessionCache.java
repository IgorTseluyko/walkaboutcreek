package com.hotel.wac.session;

import com.google.common.cache.Cache;
import com.google.common.cache.CacheBuilder;
import com.hotel.wac.entity.Client;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.Objects;
import java.util.concurrent.TimeUnit;

/**
 * Created by Igor_Tseluiko on 8/13/2015.
 */
@Component
public class SessionCache {

    @Value("${expiredTime}")
    private static int expiredTime;
    @Value("${size}")
    private static int size;

    private static Cache<String, Client> cache = CacheBuilder
            .newBuilder()
            .expireAfterWrite(expiredTime, TimeUnit.MINUTES)
            .maximumSize(size)
            .build();

    public void put(String token, Client client) {
        cache.put(token, client);
    }

    public boolean checkToken(String token) {
        Client client = cache.getIfPresent(token);
        return Objects.isNull(client);
    }

}
