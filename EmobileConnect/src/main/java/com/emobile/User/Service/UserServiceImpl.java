package com.emobile.User.Service;

import com.emobile.User.Model.User;
import com.emobile.User.Repo.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService{
    private UserRepo userRepo;

    @Autowired
    public UserServiceImpl(UserRepo userRepo){
        this.userRepo = userRepo;
    }

    @Override
    public List<User> findAll(){
        return (List<User>) userRepo.findAll();
    }

}
