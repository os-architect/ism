package api.implementation.controllers.character;

import api.implementation.config.Config;
import api.implementation.model.Character;
import api.implementation.util.Util;
import api.meta.model.controller.ModelRouteController;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
public class CharacterRouteController extends ModelRouteController<Character> {

    public CharacterRouteController() {
        super(Config.characterModelController);
    }

    @PostMapping("/character")
    public String create(@RequestBody Character model) {
        try {
            this.getModelController().save(model);
            return Util.toJson(model);
        } catch (Exception e) {
            e.printStackTrace();
            return e.getMessage();
        }
    }

    @PatchMapping("/character")
    public String update(@RequestBody Character model) {
        try {
            this.getModelController().update(model);
            return Util.toJson(model);
        } catch (Exception e) {
            e.printStackTrace();
            return e.getMessage();
        }
    }

    @DeleteMapping("/character/{id}")
    public String delete(@PathVariable("id") UUID id) {
        try {
            this.getModelController().delete(id);
            return "Entity deleted";
        } catch (Exception e) {
            e.printStackTrace();
            return e.getMessage();
        }
    }

    @GetMapping("/character/{id}")
    public String get(@PathVariable("id") UUID id) {
        try {
            Character character = this.getModelController().get(id);
            return Util.toJson(character);
        } catch (Exception e) {
            e.printStackTrace();
            return e.getMessage();
        }
    }
}
