package com.utc.dev.repo;

import com.mongodb.client.result.UpdateResult;

public interface CustomUserRepo {

    UpdateResult update(String username, String name);
}
