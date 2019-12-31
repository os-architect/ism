package core.model;

import java.io.Serializable;
import java.util.UUID;

public abstract class Model implements Serializable {

    private UUID id;

    public Model(UUID id) {
        this.id = id;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }
}
