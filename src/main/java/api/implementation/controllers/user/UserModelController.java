package api.implementation.controllers.user;

import api.implementation.config.Config;
import api.implementation.model.User;
import api.implementation.util.Util;
import api.meta.model.controller.ModelController;
import core.data.Redis;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class UserModelController extends ModelController<User> {

    public static String key = "usernames";

    public UserModelController() {
        super(Config.userRepository);
    }

    @Override
    public User save(User model) throws Exception {

        List<String> userList;

        try {

            userList = Util.fromJson(Redis.get(key), List.class);

            if(userList.contains(model.getName()))
                return null; // We don't want a user that already exists

        } catch (NullPointerException e) {
            userList = new ArrayList<>();
        }

        model.setId(UUID.randomUUID());
        model = this.getRepository().save(model);

        userList.add(model.getName());
        Redis.put(key, Util.toJson(userList));

        return model;

    }

    @Override
    public User update(User model) throws Exception {
        return this.getRepository().save(model);
    }

    @Override
    public boolean delete(UUID id) throws Exception {
        return this.getRepository().delete(id);
    }

    @Override
    public User get(UUID id) throws Exception {
        return this.getRepository().get(id);
    }
}
