package com.pandy.elasticsearch.service.impl;

import com.pandy.elasticsearch.dao.UserRepository;
import com.pandy.elasticsearch.model.User;
import com.pandy.elasticsearch.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public long count() {
        return userRepository.count();
    }

    @Override
    public User save(User user) {
        return userRepository.save(user);
    }

    @Override
    public void delete(User user) {

    }

    @Override
    public Iterable<User> getAll() {
        return userRepository.findAll();
    }

    @Override
    public List<User> getByName(String name) {
        return null;
    }

    @Override
    public Page<User> pageQuery(Integer pageNo, Integer pageSize, String kw) {
        return null;
    }
}
