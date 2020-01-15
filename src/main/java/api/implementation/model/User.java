package api.implementation.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import core.model.Model;

import java.util.UUID;

@JsonIgnoreProperties(ignoreUnknown = true)
public class User implements Model {

    private UUID id;
    private String name;
    private String password;
    private UUID characterId;

    @JsonCreator
    public User(@JsonProperty("name") String name,
                @JsonProperty("password") String password,
                @JsonProperty("characterId") String characterId) {
        this.name = name;
        this.password = password;
        this.characterId = UUID.fromString(characterId);
    }

    public User(){}

    public String getName() {
        return name;
    }

    public String getPassword() {
        return password;
    }

    public UUID getCharacterId() {
        return characterId;
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
