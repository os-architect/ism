package api.implementation.model;

import core.model.Model;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;
import java.util.UUID;

public class Authentication extends Model {

    private long sessionStart;
    private List<String> policies;

    @JsonCreator
    public Authentication(@JsonProperty("id") UUID id, @JsonProperty("sessionStart") long sessionStart, @JsonProperty("policies") List<String> policies) {
        super(id);
        this.sessionStart = sessionStart;
        this.policies = policies;
    }

    public long getSessionStart() {
        return sessionStart;
    }

    public void setSessionStart(long sessionStart) {
        this.sessionStart = sessionStart;
    }

    public List<String> getPolicies() {
        return policies;
    }

    public void setPolicies(List<String> policies) {
        this.policies = policies;
    }

}
