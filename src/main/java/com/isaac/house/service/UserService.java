package com.isaac.house.service;

import com.isaac.house.entity.User;
import com.isaac.house.repository.UserRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepo userRepo;

    public User createUser(User user){
        if (user.getUsername() == null || user.getUsername().isEmpty()) {
            throw new IllegalArgumentException("Username cannot be null or empty");
        }

        if (user.getRole() == null || user.getRole().isEmpty()) {
            throw new IllegalArgumentException("Role cannot be null or empty");
        }
        return userRepo.save(user);
    }

    public List<User> getAllUser(){
        return userRepo.findAll();
    }

    public User getUserById(long id){
        return userRepo.findById(id).orElse(null);
    }

    public User updateUser(Long id, User user){
        User searchUser = userRepo.findById(id)
                .orElseThrow(() -> new RuntimeException("User not found with ID: " + id));
        searchUser.setRole(user.getRole());
        searchUser.setUsername(user.getUsername());
        userRepo.save(searchUser);

        return searchUser;
    }

    public String deleteUser(long id){
        userRepo.deleteById(id);
        return "deleted!";
    }

}
