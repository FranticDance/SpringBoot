package com.my.config;

import com.my.bean.Employee;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.cache.RedisCacheManager;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.Jackson2JsonRedisSerializer;

import java.net.UnknownHostException;

/**
 * @author admin
 * @create 2018-07-23 11:27
 */
@Configuration
public class MyCacheConfig {

    @Bean
    public RedisTemplate<Object, Employee> empRedisTemplate(
            RedisConnectionFactory redisConnectionFactory)
            throws UnknownHostException {
        RedisTemplate<Object, Employee> template = new RedisTemplate<Object, Employee>();
        template.setConnectionFactory(redisConnectionFactory);
        Jackson2JsonRedisSerializer jackson2JsonRedisSerializer = new Jackson2JsonRedisSerializer(Employee.class);
        template.setDefaultSerializer(jackson2JsonRedisSerializer);
        return template;
    }

    //默认的RedisCacheManager缓存数据，会按照jdk序列化机制来序列化数据
    //如果想按照json来缓存数据，可以如下自已定制一个RedisCacheManager，传入上面已经修改了序列化器的empRedisTemplate
    @Bean
    public RedisCacheManager empCacheManager(RedisTemplate<Object, Employee> empRedisTemplate) {
        RedisCacheManager cacheManager = new RedisCacheManager(empRedisTemplate);
        //使用前缀，默认会将CacheName作为前缀
        cacheManager.setUsePrefix(true);
        return cacheManager;
    }
}
