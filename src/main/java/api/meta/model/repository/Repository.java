package api.meta.model.repository;

import api.implementation.data.Redis;
import api.implementation.model.Authentication;
import api.implementation.util.Util;
import api.meta.model.Model;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.springframework.web.client.HttpClientErrorException;

import javax.validation.constraints.Null;
import java.io.IOException;
import java.util.HashMap;
import java.util.UUID;

public class Repository<M extends Model> {

    private Class<M> modelClass;

    public Repository(Class<M> modelClass) {
        this.modelClass = modelClass;
    }

    public M get(UUID id) throws IOException, NullPointerException {

        String objJSON = Redis.get(modelClass.getName() + id.toString());

        if (objJSON == null) {
            throw new NullPointerException();
        }

        return Util.fromJson(objJSON, modelClass);

    }

    public M update(M model) throws IOException {
        Redis.put(modelClass.getName() + model.getId().toString(), Util.toJson(model));
        return get(model.getId());
    }

    public boolean delete(UUID id) throws Exception {
        Redis.delete(modelClass.getName() + id);
        return true;
    }

}
