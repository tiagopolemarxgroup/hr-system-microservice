package com.ms.userapi.service;

import com.ms.userapi.domain.User;
import com.ms.userapi.exception.ObjectNotFound;
import com.ms.userapi.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    public User findById(Long id) {
        return userRepository.findById(id).orElseThrow(() -> new ObjectNotFound("user not found"));
    }

    public List<User> findAll() {
        return userRepository.findAll();
    }
}
