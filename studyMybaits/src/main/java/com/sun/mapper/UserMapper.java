package com.sun.mapper;

import com.sun.pojo.User;


import java.util.List;

public interface UserMapper {
//    User findUserById(@Param("userId") long userId);
User findUserById(int userId);
    List<User> findUserList();
}
