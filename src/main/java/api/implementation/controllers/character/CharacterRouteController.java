package api.implementation.controllers.character;

import api.implementation.config.Config;
import api.implementation.model.Character;
import api.implementation.util.Util;
import api.meta.model.controller.ModelRouteController;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.UUID;

public class CharacterRouteController extends ModelRouteController<Character> {

    public CharacterRouteController() {
        super(Config.characterModelController);
    }

    @PostMapping("/character")
    public String create(Character model) {
        try {
            this.getModelController().save(model);
            return Util.toJson(model);
        } catch (Exception e) {
            e.printStackTrace();
            return e.getMessage();
        }
    }

    @PatchMapping("/character")
    public String update(Character model) {
        try {
            this.getModelController().update(model);
            return Util.toJson(model);
        } catch (Exception e) {
            e.printStackTrace();
            return e.getMessage();
        }
    }

    @DeleteMapping("/character/{id}")
    public String delete(UUID id) {
        try {
            this.getModelController().delete(id);
            return "Entity deleted";
        } catch (Exception e) {
            e.printStackTrace();
            return e.getMessage();
        }
    }

    @GetMapping("/character")
    public String get(UUID id) {
        try {
            Character character = this.getModelController().get(id);
            return Util.toJson(character);
        } catch (Exception e) {
            e.printStackTrace();
            return e.getMessage();
        }
    }
}
