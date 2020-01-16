package api.implementation.controllers.character;

import api.implementation.config.Config;
import api.implementation.model.Character;
import api.implementation.model.User;
import api.meta.model.controller.ModelController;

import java.util.UUID;

public class CharacterModelController extends ModelController<Character> {

    public CharacterModelController() {
        super(Config.charRepository);
    }

    @Override
    public Character save(Character model) throws Exception {

        try {
            // Validate that User exists first
            User user = Config.userModelController.get(model.getUserId());

            if (user.getCharacterId() != null && model.getId() != null && user.getCharacterId() != model.getId()) {
                throw new Exception("User has a different characterId");
            }

            if (model.getId() == null) {
                UUID id = UUID.randomUUID();
                model.setId(id);
                user.setCharacterId(id);
            }
            /* todo: catch failure here and rollback */Config.userModelController.save(user);
            /* todo: catch failure here and rollback */return this.getRepository().save(model);
        } catch (Exception e) {
            throw e;
        }

    }

    @Override
    public Character update(Character model) throws Exception {
        return this.getRepository().save(model);
    }

    @Override
    public boolean delete(UUID id) throws Exception {
        try {
            Character character = this.get(id);
            User user = Config.userModelController.get(character.getUserId());
            user.setCharacterId(null);
            /* todo: catch failure here and rollback */Config.userModelController.save(user);
            /* todo: catch failure here and rollback */return this.getRepository().delete(id);
        } catch (Exception e) {
            return false;
        }
    }

    @Override
    public Character get(UUID id) throws Exception {
        return this.getRepository().get(id);
    }

}
