package cn.stackbox.demo.repository;

import cn.stackbox.demo.entity.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User, Long> {}
