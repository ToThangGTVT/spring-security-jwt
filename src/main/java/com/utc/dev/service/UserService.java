package com.utc.dev.service;

import com.utc.dev.model.User;
import com.utc.dev.repo.UserRepo;
import org.springframework.beans.BeanUtils;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class UserService {

    private MongoTemplate mongoTemplate;

    private UserRepo userRepo;

    public UserService(UserRepo userRepo) {
        this.userRepo = userRepo;
    }

    @Transactional
    public User update(String username, String user){
        User userDb = userRepo.findByUsername(username).get(0);
        BeanUtils.copyProperties(user, userDb);
        userDb.setEmail("Tothang97nbvn@gmail.com");
        return userRepo.save(userDb);
    }

}
