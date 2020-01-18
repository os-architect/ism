package api.implementation.controllers.model.user;

import api.implementation.config.Config;
import api.implementation.model.User;
import api.meta.model.controller.ModelController;

import java.util.UUID;

public class UserModelController extends ModelController<User> {

    public UserModelController() {
        super(Config.userRepository);
    }

    @Override
    public User save(User model) throws Exception {

        if (model.getId() == null) {
            model.setId(UUID.randomUUID());
        }

        return this.getRepository().save(model);

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
