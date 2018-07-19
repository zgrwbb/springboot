package com.example.mybatisredisannotation.configuration;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.cache.RedisCacheConfiguration;
import org.springframework.data.redis.cache.RedisCacheManager;
import org.springframework.data.redis.cache.RedisCacheWriter;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.RedisSerializationContext;
import org.springframework.data.redis.serializer.RedisSerializer;

/**
 * @author wangbobo
 * @date 2018/6/27 14:44
 */
@SuppressWarnings("Duplicates")
@EnableCaching
@Configuration
public class RedisConfig {
    private Logger logger = LoggerFactory.getLogger(RedisConfig.class);
//    /**
//     * template 用这个
//     */
//    @Bean
//    public RedisTemplate<?, ?> redisTemplate(RedisConnectionFactory redisConnectionFactory) {
//        RedisTemplate<?, ?> redisTemplate = new RedisTemplate<>();
//        // 连接工厂
//        redisTemplate.setConnectionFactory(redisConnectionFactory);
//
//        redisTemplate.setKeySerializer(RedisSerializer.string());
//        redisTemplate.setHashKeySerializer(RedisSerializer.string());
//        redisTemplate.setValueSerializer(RedisSerializer.json());
//        redisTemplate.setHashValueSerializer(RedisSerializer.json());
//        redisTemplate.setDefaultSerializer(RedisSerializer.json());
//        logger.info("初始化Redis成功");
//        return redisTemplate;
//    }

    /**
     * 缓存管理器
     * 注解用这个
     *
     * @param connectionFactory connectionFactory
     * @return cacheManager
     */
    @Bean
    public RedisCacheManager redisCacheManager(RedisConnectionFactory connectionFactory) {
        //初始化一个RedisCacheWriter
        RedisCacheWriter redisCacheWriter = RedisCacheWriter.nonLockingRedisCacheWriter(connectionFactory);
        // 设置序列化方式
        RedisSerializationContext.SerializationPair<Object> valuePair = RedisSerializationContext.SerializationPair.fromSerializer(RedisSerializer.json());
        RedisSerializationContext.SerializationPair<String> keyPair = RedisSerializationContext.SerializationPair.fromSerializer(RedisSerializer.string());
        RedisCacheConfiguration redisCacheConfiguration = RedisCacheConfiguration.defaultCacheConfig().serializeKeysWith(keyPair).serializeValuesWith(valuePair);
        //初始化RedisCacheManager
        logger.info("\n-------------------->  初始化RedisCacheManager成功");
        return new RedisCacheManager(redisCacheWriter, redisCacheConfiguration);
    }
}

