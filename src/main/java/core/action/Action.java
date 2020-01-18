package core.action;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.UUID;

public class Action {

    private UUID initiator;

    public Action(UUID initiator) {
        this.initiator = initiator;
    }

    @JsonProperty("initiator")
    public UUID getInitiator() {
        return initiator;
    }

    @JsonProperty("initiator")
    public void setInitiator(UUID initiator) {
        this.initiator = initiator;
    }
}
