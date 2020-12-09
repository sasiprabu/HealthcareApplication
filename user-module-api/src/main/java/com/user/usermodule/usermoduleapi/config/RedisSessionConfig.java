package com.user.usermodule.usermoduleapi.config;

import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.lettuce.LettuceConnectionFactory;
import org.springframework.session.data.redis.config.annotation.web.server.EnableRedisWebSession;
import org.springframework.session.web.context.AbstractHttpSessionApplicationInitializer;

/**
 * RedisSessionConfig
 * @author – Sasiprabu
 */
@EnableRedisWebSession
@Configuration
@ConditionalOnProperty(name = "redis.cache", havingValue = "true")
public class RedisSessionConfig extends AbstractHttpSessionApplicationInitializer {
    public LettuceConnectionFactory redisConnectionFactory(){
        return new LettuceConnectionFactory();
    }
}
