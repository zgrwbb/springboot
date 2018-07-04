package com.example.elasticsearchquery.repository;

import com.example.elasticsearchquery.domain.City;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

/**
 * @author wangbobo
 * @date 2018/7/4 11:17
 */
public interface CityRepository extends ElasticsearchRepository<City,Long> {
}
