package api.implementation.config;

import api.implementation.controllers.character.CharacterModelController;
import api.implementation.controllers.user.UserModelController;
import api.implementation.model.Character;
import api.implementation.model.User;
import api.implementation.repository.RedisRepository;
import api.meta.model.repository.AbstractRepository;
import org.springframework.context.EnvironmentAware;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;

@Configuration
public class Config implements EnvironmentAware {

    private static Environment env;
    private static Config _instance;

    public static AbstractRepository<User> userRepository = new RedisRepository<User>(User.class);
    public static AbstractRepository<Character> charRepository = new RedisRepository<Character>(Character.class);


    public static UserModelController userModelController = new UserModelController();
    public static CharacterModelController characterModelController = new CharacterModelController();

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
