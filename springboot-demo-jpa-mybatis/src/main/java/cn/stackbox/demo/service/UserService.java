package cn.stackbox.demo.service;

import cn.stackbox.demo.entity.User;

import java.util.List;

public interface UserService {

    // 增
    User save (User user);

    // 删
    Boolean del (Long id);

    // 改
    User update (User user);

    // 查
    List<User> list (Long id);
}
