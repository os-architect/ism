package api.implementation.controllers.user;

import api.implementation.model.User;
import api.implementation.repository.RedisRepository;
import api.implementation.util.Util;
import api.meta.model.controller.ModelController;
import core.data.Redis;

import java.io.IOException;
import java.util.List;

public class UserModelController extends ModelController<User, RedisRepository<User>> {

    public static String key = "usernames";

    public UserModelController() {
        super(new RedisRepository<User>(User.class));
    }

    protected static boolean addUser(String userName) throws IOException {
        List<String> userList = Util.fromJson(Redis.get(key), List.class);
        if (userList.contains(userName))
            return false;
        else {
            userList.add(userName);
            Redis.put(key, Util.toJson(userList));
            return true;
        }
    }

}
