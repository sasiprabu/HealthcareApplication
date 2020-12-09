package com.user.usermodule.usermoduleapi.config;

import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.cache.RedisCacheConfiguration;
import org.springframework.data.redis.cache.RedisCacheManager;
import org.springframework.data.redis.cache.RedisCacheWriter;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.serializer.JdkSerializationRedisSerializer;
import org.springframework.data.redis.serializer.RedisSerializationContext.SerializationPair;

import java.time.Duration;
import java.util.HashMap;
import java.util.Map;

/**
 * RedisCacheConfig
 * @author – Sasiprabu
 */
@Configuration
@EnableCaching
public class RedisCacheConfig {

    @Bean
    public RedisCacheManager getRedisCacheManager(RedisConnectionFactory connectionFactory) {
        RedisCacheWriter cacheWriter = RedisCacheWriter.lockingRedisCacheWriter(connectionFactory);
        ClassLoader loader = this.getClass().getClassLoader();
        JdkSerializationRedisSerializer jdkSerializer = new JdkSerializationRedisSerializer(loader);
        SerializationPair<Object> pair = SerializationPair.fromSerializer(jdkSerializer);
        RedisCacheConfiguration cacheConfig = RedisCacheConfiguration.defaultCacheConfig().serializeValuesWith(pair);
        Map<String, RedisCacheConfiguration> initialCacheConfigurations = new HashMap<>();
        cacheConfig = cacheConfig.entryTtl(Duration.ofSeconds(3600));
        initialCacheConfigurations.put("user", cacheConfig.entryTtl(Duration.ofSeconds(3600)));
        RedisCacheManager cacheManager = new RedisCacheManager(cacheWriter, cacheConfig, initialCacheConfigurations);
        return cacheManager;
    }
}
