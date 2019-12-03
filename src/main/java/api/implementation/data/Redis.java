package api.implementation.data;

import api.implementation.config.Config;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

import java.time.Duration;

public class Redis {

    private static Redis _instance = null; // only access through getInstance()

    private JedisPool pool;

    private Redis() {
        final JedisPoolConfig poolConfig = new JedisPoolConfig();
        poolConfig.setMaxTotal(128);
        poolConfig.setMaxIdle(128);
        poolConfig.setMinIdle(16);
        poolConfig.setTestOnBorrow(true);
        poolConfig.setTestOnReturn(true);
        poolConfig.setTestWhileIdle(true);
        poolConfig.setMinEvictableIdleTimeMillis(Duration.ofSeconds(60).toMillis());
        poolConfig.setTimeBetweenEvictionRunsMillis(Duration.ofSeconds(30).toMillis());
        poolConfig.setNumTestsPerEvictionRun(3);
        poolConfig.setBlockWhenExhausted(true);
        this.pool = new JedisPool(poolConfig, Config.get("REDIS_HOST"));
    }


    public static String get(String key) {
        try (Jedis jedis = getInstance().pool.getResource()) {
            return jedis.get(key);
        }
    }

    public static String put(String key, String value) {
        try (Jedis jedis = getInstance().pool.getResource()) {
            return jedis.set(key, value);
        }
    }

    public static void delete(String... keys) {
        try (Jedis jedis = getInstance().pool.getResource()) {
            jedis.del(keys);
        }
    }

    public static Redis getInstance() {
        if (_instance == null) {
            _instance = new Redis();
        }
        return _instance;
    }

}
