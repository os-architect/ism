package api.implementation.data;

import api.implementation.config.Parameters;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

import java.time.Duration;

public class Redis {

    private static Redis _instance = new Redis();
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
        _instance = this;
        _instance.pool = new JedisPool(poolConfig, Parameters.REDIS_HOST);
    }


    public static String get(String key) {
        try (Jedis jedis = _instance.pool.getResource()) {
            return jedis.get(key);
        }
    }

    public static String put(String key, String value) {
        try (Jedis jedis = _instance.pool.getResource()) {
            return jedis.set(key, value);
        }
    }

    public static void delete(String... keys) {
        try (Jedis jedis = _instance.pool.getResource()) {
            jedis.del(keys);
        }
    }

}
