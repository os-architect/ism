package core.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.Serializable;
import java.util.UUID;

public interface Model extends Serializable {

    @JsonProperty("id")
    UUID getId();

    @JsonProperty("id")
    void setId(UUID id);

}
