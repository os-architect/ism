package core.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.Serializable;
import java.util.UUID;

public interface Model extends Serializable {

    UUID getId();
    void setId(UUID id);

}
