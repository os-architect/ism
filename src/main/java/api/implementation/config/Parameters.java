package api.implementation.config;

import org.springframework.beans.factory.annotation.Value;

public class Parameters {

    @Value("${REDIS_HOST:localhost}")
    public static String REDIS_HOST;

    @Value("${KAFKA_HOST:localhost}")
    public static String KAFKA_HOST;


}
