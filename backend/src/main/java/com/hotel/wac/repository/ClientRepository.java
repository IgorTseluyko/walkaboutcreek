package com.hotel.wac.repository;

import com.hotel.wac.entity.Client;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by Igor_Tseluiko on 8/12/2015.
 * Spring-Data repository for table "customer"
 */
public interface ClientRepository extends JpaRepository<Client, Long> {
}
