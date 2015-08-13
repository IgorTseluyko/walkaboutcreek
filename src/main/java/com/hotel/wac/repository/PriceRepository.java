package com.hotel.wac.repository;

import com.hotel.wac.entity.Price;
import org.springframework.data.mongodb.repository.MongoRepository;

/**
 * Created by mariiarudenko on 8/13/15.
 */
public interface PriceRepository extends MongoRepository<Price, Integer> {
}
