package api.implementation.model;

import api.meta.model.Model;

import java.util.List;

public class Authentication extends Model {

    private long sessionStart;
    private List<String> policies;

    public Authentication(long sessionStart, List<String> policies) {
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
