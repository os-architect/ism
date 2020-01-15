package core.data;

import api.implementation.config.Config;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

import javax.validation.constraints.Null;
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


    public static String get(String key) throws NullPointerException {
        try (Jedis jedis = getInstance().pool.getResource()) {
            String returnValue = jedis.get(key);
            if (returnValue == null)
                throw new NullPointerException();
            System.out.println("[REDIS] Reading: " + returnValue);
            return returnValue;
        }
    }

    public static String put(String key, String value) {
        try (Jedis jedis = getInstance().pool.getResource()) {
            System.out.println("[REDIS] Writing: " + key + " with " + value);
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
