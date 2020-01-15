package api.meta.model.controller;

import api.meta.model.repository.AbstractRepository;
import core.model.Model;

import java.util.UUID;

public abstract class ModelRouteController<M extends Model> {

    private ModelController<M> modelController;

    public ModelRouteController(ModelController<M> modelController) {
        this.modelController = modelController;
    }

    public abstract String create(M model);
    public abstract String update(M model);
    public abstract String delete(UUID id);
    public abstract String get(UUID id);

    public ModelController<M> getModelController() {
        return modelController;
    }
}
