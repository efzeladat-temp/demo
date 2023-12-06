package com.bci.ejercicio.demo.service;

import java.sql.Timestamp;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bci.ejercicio.demo.domain.entity.User;
import com.bci.ejercicio.demo.domain.repository.UserRepository;
import com.bci.ejercicio.demo.utils.PasswordManager;

@Service
public class UserService {

    @Autowired UserRepository userRepository;

    @Autowired PasswordManager passwordManager;
    
    public User signUp(User user){
        user.setCreated(new Timestamp(System.currentTimeMillis()));
        user.setIsActive(Boolean.TRUE);
        user.setPassword(passwordManager.getEncryptedPassword(user.getPassword()));
        User resp = userRepository.save(user);
        return resp;
    }

    public Optional<User> getUser(String username, String password){
        String passEncrypt = passwordManager.getEncryptedPassword(password);
        Optional<User> user = userRepository.findByCredentials(username);
        if(!user.get().getPassword().equals(passEncrypt)){
            user = null;
        }
        return user;
    }
    
}
