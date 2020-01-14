package api.meta.model.controller;

import api.meta.model.repository.AbstractRepository;
import core.model.Model;

public abstract class ModelRouteController<M extends Model, R extends AbstractRepository<M>> {

    private ModelController modelController;

    public ModelRouteController(ModelController<M, R> modelController) {
        this.modelController = modelController;
    }

    public abstract create();
    public abstract update();
    public abstract delete();
    public abstract get();

}
