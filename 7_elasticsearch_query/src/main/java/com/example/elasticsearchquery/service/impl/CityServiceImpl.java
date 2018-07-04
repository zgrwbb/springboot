package com.example.elasticsearchquery.service.impl;

import com.example.elasticsearchquery.domain.City;
import com.example.elasticsearchquery.repository.CityRepository;
import com.example.elasticsearchquery.service.CityService;
import org.elasticsearch.index.query.QueryBuilders;
import org.elasticsearch.index.query.functionscore.FunctionScoreQueryBuilder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.elasticsearch.core.query.NativeSearchQueryBuilder;
import org.springframework.data.elasticsearch.core.query.SearchQuery;
import org.springframework.stereotype.Service;

import java.util.List;

import static org.elasticsearch.index.query.QueryBuilders.matchQuery;
import static org.elasticsearch.index.query.functionscore.ScoreFunctionBuilders.weightFactorFunction;

/**
 * @author wangbobo
 * @date 2018/7/4 11:21
 */
@Service
public class CityServiceImpl implements CityService {
    private Logger logger = LoggerFactory.getLogger(CityServiceImpl.class);

    private CityRepository cityRepository;

    @Autowired
    public CityServiceImpl(CityRepository cityRepository) {
        this.cityRepository = cityRepository;
    }

    @Override
    public Long saveCity(City city) {
        cityRepository.save(city);
        return city.getId();
    }

    @Override
    public List<City> searchCity(Integer pageNumber, Integer pageSize, String searchContent) {
        /*初始化page参数*/
        if (pageNumber == null || pageNumber < 0) {
            pageNumber = 0;
        }
        if (pageSize == null || pageSize < 1) {
            pageNumber = 5;
        }
        logger.info("\n searchCity: searchContent [" + searchContent + "] \n ");
        //构建搜索查询
        SearchQuery searchQuery = getCitySearchQuery(pageNumber, pageSize, searchContent);
        logger.info("\n searchCity: searchContent [" + searchContent + "] \n DSL  = \n " + searchQuery.getQuery().toString());
        Page<City> cityPage = cityRepository.search(searchQuery);
        return cityPage.getContent();
    }

    /**
     * 权重分求和模式
     *
     * @param pageNumber    pageNumber
     * @param pageSize      pageSize
     * @param searchContent searchContent
     * @return SearchQuery
     */
    private SearchQuery getCitySearchQuery(Integer pageNumber, Integer pageSize, String searchContent) {
        // 权重分求和模式
        String scoreModeSum = "sum";

        // 由于无相关性的分值默认为 1 ，设置权重分最小值为 10
        Float minScore = 10.0F;
        FunctionScoreQueryBuilder.FilterFunctionBuilder[] functions = {
                new FunctionScoreQueryBuilder.FilterFunctionBuilder(
                        matchQuery("name", searchContent),weightFactorFunction(500)),
                new FunctionScoreQueryBuilder.FilterFunctionBuilder(
                        matchQuery("description", searchContent),weightFactorFunction(1000).setWeight(minScore))
        };
        FunctionScoreQueryBuilder functionScoreQueryBuilder = QueryBuilders.functionScoreQuery(functions);

        Pageable pageable = PageRequest.of(pageNumber, pageSize);
        return new NativeSearchQueryBuilder().withPageable(pageable).withQuery(functionScoreQueryBuilder).build();
    }
}
