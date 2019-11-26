package api.meta.model.repository;

import api.meta.model.Model;

import java.util.HashMap;
import java.util.UUID;

public abstract class Repository<E extends Model> {

    public abstract E get(UUID id) throws Exception;
    public abstract E update(UUID id, HashMap parameters) throws Exception;
    public abstract boolean delete(UUID id) throws Exception;

}
