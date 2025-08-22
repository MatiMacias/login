package com.mati.login.Service;

import com.mati.login.Model.User;
import com.mati.login.Repository.UserRepo;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserRepo userRepo;

    public List<User> listUsers (){
        return userRepo.findAll();
    }

    public User findUserById (Long id){
        User user = userRepo.findById(id)
                .orElseThrow(()-> new EntityNotFoundException("user not found"));
        return user;
    }

    public User createUser (User user){
        return userRepo.save(user);
    }

    public User updateUser (User user, Long id){
        User newUser = userRepo.findById(id)
                .orElseThrow(()->new EntityNotFoundException("user not found"));

        newUser.setFirstname(user.getFirstname());
        newUser.setLastname(user.getLastname());
        newUser.setEmail(user.getEmail());
        newUser.setPassword(user.getPassword());
        newUser.setRole(user.getRole());

        return userRepo.save(newUser);
    }

    public void deleteUserById(Long id){
        if(!userRepo.existsById(id)){
            throw new EntityNotFoundException("user not found");
        }

        userRepo.deleteById(id);
    }

}
