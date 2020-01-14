package api.meta.model.controller;

import api.meta.model.repository.AbstractRepository;
import core.model.Model;

public abstract class ModelController<M extends Model, R extends AbstractRepository<M>> {

    private R respository;

    public ModelController(R repository) {
        this.respository = repository;
    }

    public R getRepository() {
        return respository;
    }
}
