package com.example.userservice.service;

import com.example.userservice.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.Map;

@Service
public class UserService {
    private Map<String, User> userRepository = new HashMap<>();

    @Autowired
    private RestTemplate restTemplate;

    public User addUser(User user) {
        userRepository.put(user.getId(), user);
        return user;
    }

    public User getUserById(String id) {
        return userRepository.get(id);
    }

    public User updateUser(String id, User user) {
        userRepository.put(id, user);
        return user;
    }

    public User deleteUser(String id) {
        return userRepository.remove(id);
    }

    public String getUserCourses(String userId) {
        String courseServiceUrl = "http://localhost:8080/courses/user/" + userId;
        return restTemplate.getForObject(courseServiceUrl, String.class);
    }
}
