package api.meta.model.controller;

import api.meta.model.repository.AbstractRepository;
import core.model.Model;

import java.util.UUID;

public abstract class ModelController<M extends Model> {

    private AbstractRepository<M> respository;

    public ModelController(AbstractRepository<M> repository) {
        this.respository = repository;
    }

    public abstract M save(M model) throws Exception;
    public abstract M update(M model)  throws Exception;
    public abstract boolean delete(UUID id)  throws Exception;
    public abstract M get(UUID id) throws Exception;

    public AbstractRepository<M> getRepository() {
        return respository;
    }
}
