package api.implementation.repository;

import api.meta.model.repository.AbstractRepository;
import core.data.Redis;
import api.implementation.util.Util;
import core.model.Model;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.springframework.web.client.HttpClientErrorException;

import javax.validation.constraints.Null;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class RedisRepository<M extends Model> implements AbstractRepository<M> {

    private Class<M> modelClass;

    public RedisRepository(Class<M> modelClass) {
        this.modelClass = modelClass;
    }

    public M get(UUID id) throws IOException, NullPointerException {

        String objJSON = Redis.get(modelClass.getName() + id.toString());

        if (objJSON == null) {
            throw new NullPointerException();
        }

        return Util.fromJson(objJSON, modelClass);

    }

    @Override
    public Model save(Model model) throws Exception {
        Redis.put(modelClass.getName() + model.getId().toString(), Util.toJson(model));
        return get(model.getId());
    }

    @Override
    public boolean delete(UUID id) {
        Redis.delete(modelClass.getName() + id);
        return true;
    }

    @Override
    public List<M> getAll() throws Exception {
        String allString = Redis.get(modelClass.getName());
        List<String> allJson = Util.fromJson(allString, ArrayList.class);
        List<M> allModels = new ArrayList<M>();

        for (String modelJson : allJson)
            allModels.add(Util.fromJson(modelJson, modelClass));

        return allModels;
    }
}
