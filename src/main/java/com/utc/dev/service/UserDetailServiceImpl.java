package com.utc.dev.service;

import com.utc.dev.model.User;
import com.utc.dev.repo.UserRepo;
import com.utc.dev.model.CustomUserDetail;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserDetailServiceImpl implements UserDetailsService {

    private UserRepo userRepo;

    public UserDetailServiceImpl(UserRepo userRepo) {
        this.userRepo = userRepo;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        List<User> userList = userRepo.findByUsername(username);
        if (userList.size() == 0) {
            return null;
        } else {
            CustomUserDetail customUserDetail = new CustomUserDetail();
            customUserDetail.setUser(userList.get(0));
            return customUserDetail;
        }
    }

    public UserDetails loadUserById(String id) {
        CustomUserDetail customUserDetail = new CustomUserDetail();
        customUserDetail.setUser(userRepo.findBy_id(id));
        return customUserDetail;
    }


}
