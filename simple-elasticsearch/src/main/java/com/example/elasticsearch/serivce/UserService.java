package com.example.elasticsearch.serivce;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.elasticsearch.model.User;
import com.example.elasticsearch.repository.UserRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Slf4j
@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public User addUser(User user) {
        log.info("add user {}", user);
        return this.userRepository.save(user);
    }

    public User addUser(long id, String name, int age) {
        User user = User.builder().id(id).name(name).age(age).build();
        return this.userRepository.save(user);
    }

    public void deleteUser(User user) {
        log.info("delete user {}", user);
        this.userRepository.delete(user);
    }

    public void deleteUserById(Long id) {
        this.userRepository.deleteById(id);
    }

    public User getUser(Long id) {
        Optional<User> user = this.userRepository.findById(id);
        log.info("user is {}", user);
        return user.get();
    }

    public List<User> findAllUser() {
        List<User> users = new ArrayList<>();
        this.userRepository.findAll().forEach(u -> users.add(u));
        log.info("users : {}", users);
        return users;
    }

    public User updateUser(Long id, String name, Integer age) {
    	log.info("user name is {}, age is {}", name, age);
        User user = getUser(id);
        user.setName(name);
        user.setAge(age);
        return this.userRepository.save(user);
    }

}
