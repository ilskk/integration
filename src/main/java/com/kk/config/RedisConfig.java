package com.kk.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.cache.RedisCacheConfiguration;
import org.springframework.data.redis.cache.RedisCacheManager;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.GenericJackson2JsonRedisSerializer;
import org.springframework.data.redis.serializer.RedisSerializationContext;
import org.springframework.data.redis.serializer.RedisSerializer;
import org.springframework.data.redis.serializer.StringRedisSerializer;

import java.net.UnknownHostException;
import java.time.Duration;

@Configuration
public class RedisConfig {

    //过期时间
    private Duration timeToLive=Duration.ofDays(1);

    @Bean
    public RedisCacheManager cacheManager(RedisConnectionFactory factory){
        RedisCacheConfiguration configuration=RedisCacheConfiguration.defaultCacheConfig().entryTtl(timeToLive)
            .serializeKeysWith(RedisSerializationContext.SerializationPair.fromSerializer(keySerializer()))
            .serializeValuesWith(RedisSerializationContext.SerializationPair.fromSerializer(valueSerializer()))
            .disableCachingNullValues();

        RedisCacheManager manager=RedisCacheManager
                .builder(factory).cacheDefaults(configuration).transactionAware().build();
        return manager;
    }

    @Bean
    public RedisTemplate<String,Object> redisTemplate(RedisConnectionFactory factory)
                throws UnknownHostException {
        RedisTemplate<String,Object> template=new RedisTemplate<>();
        template.setConnectionFactory(factory);
        template.setKeySerializer(keySerializer());
        template.setHashKeySerializer(keySerializer());
        template.setValueSerializer(valueSerializer());
        template.setHashKeySerializer(valueSerializer());

        return template;
    }

    private RedisSerializer<String> keySerializer(){
        return new StringRedisSerializer();
    }

    private RedisSerializer<Object> valueSerializer(){
        return new GenericJackson2JsonRedisSerializer();
    }

}
