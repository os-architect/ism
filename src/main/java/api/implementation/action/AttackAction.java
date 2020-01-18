package api.implementation.action;

import com.fasterxml.jackson.annotation.JsonProperty;
import core.action.Action;
import core.geography.Direction;

public class AttackAction extends Action {

    private Direction direction;

    public AttackAction() {}

    @JsonProperty("direction")
    public Direction getDirection() {
        return direction;
    }

    @JsonProperty("direction")
    public void setDirection(int direction) {
        this.direction = Direction.values()[direction];
    }

    @JsonProperty("direction")
    public void setDirection(String direction) {
        this.direction = Direction.valueOf(direction);
    }

}
