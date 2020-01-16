package api.implementation.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import core.model.Model;

import java.util.UUID;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Character implements Model {

    private UUID id;
    private String name;
    private int x;
    private int y;
    private int health;
    private UUID userId;

    @JsonCreator
    public Character(@JsonProperty("name") String name,
                     @JsonProperty("x") int x,
                     @JsonProperty("y") int y,
                     @JsonProperty("health") int health,
                     @JsonProperty("userId") String userId) {
        this.name = name;
        this.x = x;
        this.y = y;
        this.health = health;
        this.userId = UUID.fromString(userId);
    }

    public Character(){}

    @Override
    public UUID getId() {
        return id;
    }

    @Override
    public void setId(UUID id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public UUID getUserId() {
        return userId;
    }

    public void setUserId(UUID userId) {
        this.userId = userId;
    }
}
