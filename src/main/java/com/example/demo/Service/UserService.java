package com.example.demo.Service;

import com.example.demo.Entity.User;
import com.example.demo.Repo.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService{

    @Autowired
    UserRepo userRepo;
    public boolean addUser(User user){
        if(userRepo.save(user)!= null){
            return true;
        }
        return false;
    }
}
