package api.implementation.controllers.user;

import api.implementation.model.User;
import api.implementation.util.Util;
import api.meta.model.controller.ModelRouteController;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
public class UserRouteController extends ModelRouteController<User> {

    public UserRouteController() {
        super(new UserModelController());
    }

    @PostMapping("/user")
    public String create(@RequestBody User user) {

        try {
            System.out.println("Saving");
            this.getModelController().save(user);
            return Util.toJson(user);
        } catch (Exception e) {
            e.printStackTrace();
            return "Failed";
        }

    }

    @PatchMapping("/user/{id}")
    public String update(User model) {
        return null;
    }

    @DeleteMapping("/user/{id}")
    public String delete(@PathVariable("id") UUID id) {
        return null;
    }

    @GetMapping("/user/{id}")
    public String get(@PathVariable("id") UUID id) {

        try {
            User user = this.getModelController().get(id);
            return Util.toJson(user);
        } catch (Exception e) {
            e.printStackTrace();
            return "Failed";
        }

    }
}
