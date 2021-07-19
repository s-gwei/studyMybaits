package com.sun.mapper;

import com.sun.pojo.User;
import org.apache.ibatis.annotations.Param;


import java.util.List;

public interface UserMapper {
//    User findUserById(@Param("userId") long userId);
    User findUserById(int userId);

    List<User> findUserList();

    void insertUser(@Param("userId")User user);


}
