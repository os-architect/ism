package api.implementation.controllers.user;

import api.implementation.config.Config;
import api.implementation.model.User;
import api.meta.model.controller.ModelController;

import java.util.List;
import java.util.UUID;

public class UserModelController extends ModelController<User> {

    public static String key = "usernames";

    public UserModelController() {
        super(Config.userRepository);
    }

    @Override
    public User save(User model) throws Exception {

        if (model.getId() != null) {
            throw new Exception();
        }

        model.setId(UUID.randomUUID());
        model = this.getRepository().save(model);

        return model;

    }

    @Override
    public User update(User model) throws Exception {
        return this.getRepository().save(model);
    }

    @Override
    public boolean delete(UUID id) throws Exception {

        try {
            this.get(id);
            return this.getRepository().delete(id);
        } catch (Exception e) {
            return false;
        }

    }

    @Override
    public User get(UUID id) throws Exception {
        return this.getRepository().get(id);
    }

}
