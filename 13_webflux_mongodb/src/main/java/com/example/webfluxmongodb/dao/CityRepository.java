package com.example.webfluxmongodb.dao;


import com.example.webfluxmongodb.domain.City;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;

/**
 * @author Created by wangbobo on 2018/7/20/18:04
 */
@Repository
public interface CityRepository extends ReactiveMongoRepository<City, Long> {
}
