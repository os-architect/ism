package api.implementation.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import core.model.Model;

import java.util.UUID;

public class User extends Model {

    private String name;
    private String password;
    private UUID characterId;

    @JsonCreator
    public User(@JsonProperty("id") UUID id,
                @JsonProperty("name") String name,
                @JsonProperty("password") String password,
                @JsonProperty("character-id") String characterId) {
        super(id);
        this.name = name;
        this.password = password;
        this.characterId = UUID.fromString(characterId);
    }

    public User(){
        super(UUID.randomUUID());
    }

    public String getName() {
        return name;
    }

    public String getPassword() {
        return password;
    }

    public UUID getCharacterId() {
        return characterId;
    }
}
