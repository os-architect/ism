package api.meta.model.controller;

import core.model.Model;
import api.meta.model.repository.Repository;

public abstract class BaseController<M extends Model> {

    private Repository<M> respository;

    public BaseController(Class<M> modelClass) {
        this.respository = new Repository<M>(modelClass);
    }

    public Repository<M> getRepository() {
        return respository;
    }

    public void setRespository(Repository<M> respository) {
        this.respository = respository;
    }
}
