package com.pandy.elasticsearch.service;

import com.pandy.elasticsearch.model.User;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import java.util.List;

public interface UserService {

    public long count();

    public User save(User user);

    public void delete(User user);

    public Iterable<User> getAll();

    public List<User> getByName(String name);

    public Page<User> pageQuery(Integer pageNo, Integer pageSize, String kw);
}
