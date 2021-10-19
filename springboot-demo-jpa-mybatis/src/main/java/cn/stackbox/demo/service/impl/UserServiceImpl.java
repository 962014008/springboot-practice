package cn.stackbox.demo.service.impl;

import cn.stackbox.demo.entity.User;
import cn.stackbox.demo.repository.UserRepository;
import cn.stackbox.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.Collections;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public User save(User user) {
        User saveUser = userRepository.save(user);
        return saveUser;
    }

    @Override
    public Boolean del(Long id) {
        userRepository.delete(id);
        return userRepository.exists(id);
    }

    @Override
    public User update(User user) {
        User saveUser = userRepository.save(user);
        return saveUser;
    }

    @Override
    public List<User> list(Long id) {

        List<User> userList = Collections.emptyList();

        if (id == null) {
            userList.addAll((Collection<? extends User>) userRepository.findAll());
        } else {
            userList.add(userRepository.findOne(id));
        }

        return userList;
    }
}
