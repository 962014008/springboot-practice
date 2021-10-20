package cn.stackbox.demo.mapper;

import cn.stackbox.demo.entity.User;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserMapper {

    User findByName (String name);

}
