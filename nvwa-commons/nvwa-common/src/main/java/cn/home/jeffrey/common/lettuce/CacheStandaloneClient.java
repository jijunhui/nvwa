package cn.home.jeffrey.common.lettuce;

import io.lettuce.core.RedisClient;
import io.lettuce.core.RedisURI;
import io.lettuce.core.api.StatefulRedisConnection;
import io.lettuce.core.api.async.RedisAsyncCommands;
import io.lettuce.core.api.sync.RedisCommands;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.time.Duration;

/**
 * @author:jeffrey(jeffreyji@aliyun.com)
 * @date: 2020/4/18 22:59
 * @version:1.0.0
 * @description:单击模式客户端
 */
@Slf4j
@Component
public class CacheStandaloneClient {
    @Value("${spring.redis.url}")
    private String host;
    @Value("${spring.redis.port}")
    private int port;

    private static RedisCommands<String, String> redisCommands;

    @PostConstruct
    public void init() {
        RedisURI redisURI = RedisURI.builder().withHost(host).withPort(port).withTimeout(Duration.ofSeconds(30)).build();
        RedisClient redisClient = RedisClient.create(redisURI);
        StatefulRedisConnection<String, String> connection = redisClient.connect();
        redisCommands = connection.sync();
    }

    /**
     * 字符串设置
     *
     * @param k
     * @param v
     * @return
     */
    public static String set(String k, String v) {
        return redisCommands.set(k, v);
    }

    /**
     * 获取String
     *
     * @param k
     * @return
     */
    public static String get(String k) {
        return redisCommands.get(k);
    }

    public static void main(String[] args) {
        String host = "Jeffrey";
        int port = 6379;
        RedisURI redisURI = RedisURI.builder().withHost(host).withPort(port).withTimeout(Duration.ofSeconds(30)).build();
        RedisClient redisClient = RedisClient.create(redisURI);
        StatefulRedisConnection<String, String> connection = redisClient.connect();

        System.out.println("pong");
        RedisAsyncCommands<String, String> redisAsyncCommand = connection.async();
        connection.close();
        redisClient.shutdown();
    }
}
