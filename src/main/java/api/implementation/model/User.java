package api.implementation.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import core.model.Model;

import java.util.UUID;

public class User implements Model {

    private UUID id;
    private String name;
    private String password;
    private UUID characterId;

    public User(String name, String password) {
        this.name = name;
        this.password = password;
    }

    public User(){}

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public UUID getCharacterId() {
        return characterId;
    }

    public void setCharacterId(UUID characterId) {
        this.characterId = characterId;
    }

    @Override
    public UUID getId() {
        return this.id;
    }

    @Override
    public void setId(UUID id) {
        this.id = id;
    }
}
