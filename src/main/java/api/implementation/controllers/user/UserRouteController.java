package api.implementation.controllers.user;

import api.implementation.config.Config;
import api.implementation.model.User;
import api.implementation.util.Util;
import api.meta.model.controller.ModelRouteController;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
public class UserRouteController extends ModelRouteController<User> {

    public UserRouteController() {
        super(Config.userModelController);
    }

    @PostMapping("/user")
    public String create(@RequestBody User user) {

        try {
            this.getModelController().save(user);
            return Util.toJson(user);
        } catch (Exception e) {
            e.printStackTrace();
            return e.getMessage();
        }

    }

    @PatchMapping("/user")
    public String update(@RequestBody User user) {
        try {
            this.getModelController().update(user);
            return Util.toJson(user);
        } catch (Exception e) {
            e.printStackTrace();
            return e.getMessage();
        }
    }

    @DeleteMapping("/user/{id}")
    public String delete(@PathVariable("id") UUID id) {
        try {
            this.getModelController().delete(id);
            return "Entity deleted";
        } catch (Exception e) {
            e.printStackTrace();
            return e.getMessage();
        }
    }

    @GetMapping("/user/{id}")
    public String get(@PathVariable("id") UUID id) {
        try {
            User user = this.getModelController().get(id);
            return Util.toJson(user);
        } catch (Exception e) {
            e.printStackTrace();
            return e.getMessage();
        }
    }
}
