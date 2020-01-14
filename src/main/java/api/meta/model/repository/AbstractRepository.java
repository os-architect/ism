package api.meta.model.repository;

import core.model.Model;

import java.util.UUID;

public interface AbstractRepository<M extends Model> {

    M get(UUID uuid) throws Exception;
    M save(M model) throws Exception;
    boolean delete(UUID uuid) throws Exception;
    default boolean delete(M model) throws Exception {
        return delete(model.getId());
    }

}
