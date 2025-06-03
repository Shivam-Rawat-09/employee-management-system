package com.company.ems.service;

import com.company.ems.model.User;
import com.company.ems.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public User createUser(User user) {
        return userRepository.save(user);
    }

    public Optional<User> getUserById(Long id) {
        return userRepository.findById(id);
    }

    public User updateUser(Long id, User userDetails) {
        User user = userRepository.findById(id).orElseThrow(() -> new RuntimeException("User not found"));
        user.setUsername(userDetails.getUsername());
        user.setPasswordHash(userDetails.getPasswordHash());
        user.setEmployeeId(userDetails.getEmployeeId());
        user.setRole(userDetails.getRole());
        user.setLastLogin(userDetails.getLastLogin());
        user.setAccountStatus(userDetails.getAccountStatus());
        return userRepository.save(user);
    }

    public void deleteUser(Long id) {
        userRepository.deleteById(id);
    }

    public Optional<User> findByUsername(String username) {
        return userRepository.findByUsername(username);
    }
}