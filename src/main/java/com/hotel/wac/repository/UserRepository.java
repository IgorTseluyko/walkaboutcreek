package com.hotel.wac.repository;

import com.hotel.wac.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by Igor_Tseluiko on 8/12/2015.
 */
public interface UserRepository extends JpaRepository<User, Long> {

}
