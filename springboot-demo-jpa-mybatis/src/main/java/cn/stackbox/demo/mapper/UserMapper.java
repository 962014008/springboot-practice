package cn.stackbox.demo.mapper;

import cn.stackbox.demo.entity.User;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserMapper {

    List<User> findByName (String name);

}
