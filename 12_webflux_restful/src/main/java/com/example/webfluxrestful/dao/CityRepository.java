package com.example.webfluxrestful.dao;

import com.example.webfluxrestful.domain.City;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author Created by wangbobo on 2018/7/20/18:04
 */
public interface CityRepository extends JpaRepository<City, Long> {
//    private ConcurrentMap<Long, City> repository = new ConcurrentHashMap<>();
//
//    private static final LongAdder ID_GENERATOR = new LongAdder();
//
//    public Long save(City city) {
//        Long id =Long.valueOf(String.valueOf(ID_GENERATOR));
//        city.setId(id);
//        ID_GENERATOR.increment();
//        repository.put(id, city);
//        return id;
//    }
//
//    public Collection<City> findAll() {
//        return repository.values();
//    }
//
//
//    public City getCityById(Long id) {
//        return repository.get(id);
//    }
//
//    public Long updateCity(City city) {
//        repository.put(city.getId(), city);
//        return city.getId();
//    }
//
//    public Long deleteCity(Long id) {
//        repository.remove(id);
//        return id;
//    }
}
