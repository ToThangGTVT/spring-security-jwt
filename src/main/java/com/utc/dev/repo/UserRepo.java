package com.utc.dev.repo;

import com.utc.dev.model.User;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepo extends MongoRepository<User, String> {

    User findBy_id(String id);

    List<User> findByUsername(String name);

    User findByUsernameAndPassword(String username, String password);

}
