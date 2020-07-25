package com.utc.dev.repo.impl;

import com.mongodb.client.result.UpdateResult;
import com.utc.dev.model.User;
import com.utc.dev.repo.CustomUserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.CriteriaDefinition;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Repository;

import static com.jayway.jsonpath.Criteria.where;

@Repository
public class UserRepoImpl implements CustomUserRepo {

    @Autowired
    MongoTemplate mongoTemplate;

    @Override
    public UpdateResult update(String username, String name) {
        Query query = new Query().addCriteria((CriteriaDefinition) where("username").is(username));
        return mongoTemplate.updateFirst(query, Update.update("name", name), User.class);
    }
}
