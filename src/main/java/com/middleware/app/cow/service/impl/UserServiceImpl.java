package com.middleware.app.cow.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.middleware.app.cow.domain.User;
import com.middleware.app.cow.exceptions.CowException;
import com.middleware.app.cow.repository.UserRepository;
import com.middleware.app.cow.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public Page<User> find(Integer index, Integer totalCount,User user) throws CowException {
        try {
            PageHelper.offsetPage(index, totalCount);
            return userRepository.findAll(user);
        } catch (Exception e) {
            throw new CowException();
        }
    }

    @Override
    public User get(Long id) throws CowException {
        try {
            return userRepository.findById(id);
        } catch (Exception e) {
            throw new CowException();
        }
    }

    @Override
    public void create(User user) throws CowException {
        try {
            userRepository.insert(user);
        } catch (Exception e) {
            throw new CowException();
        }
    }

    @Override
    public void update(User user) throws CowException {
        try {
            userRepository.update(user);
        } catch (Exception e) {
            throw new CowException();
        }
    }

    @Override
    public void delete(Long id) throws CowException {
        try {
            userRepository.delete(id);
        } catch (Exception e) {
            throw new CowException();
        }
    }
}
