package api.implementation.repository;

import api.implementation.data.Redis;
import api.implementation.model.Authentication;
import api.implementation.util.Util;
import api.meta.model.Model;
import api.meta.model.repository.Repository;

import java.util.HashMap;
import java.util.UUID;

public class AuthenticationRepository extends Repository<Authentication> {

    @Override
    public Authentication get(UUID id) throws Exception {
        return Util.fromJson(Redis.get("auth" + id.toString()), Authentication.class);
    }

    @Override
    public Authentication update(UUID id, Authentication authentication) throws Exception {
        Redis.put("auth-" + id.toString(), Util.toJson(authentication));
        return this.get(id);
    }

    @Override
    public boolean delete(UUID id) throws Exception {
        Redis.delete("auth-" + id);
        return true;
    }
}
