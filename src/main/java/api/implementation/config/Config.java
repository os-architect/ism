package api.implementation.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.EnvironmentAware;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;

@Configuration
public class Config implements EnvironmentAware {

    private static Environment env;
    private static Config _instance;

    public Config() {}

    private static Config getInstance() {
        if (_instance == null) {
            _instance = new Config();
        }
        return _instance;
    }

    @Override
    public void setEnvironment(final Environment environment) {
        Config.env = environment;
    }

    public static String get(String configName) {
        return getInstance().env.getProperty(configName);
    }

}
