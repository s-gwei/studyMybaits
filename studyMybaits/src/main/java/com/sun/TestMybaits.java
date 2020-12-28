package com.sun;

import com.sun.mapper.UserMapper;
import com.sun.pojo.User;
import com.sun.session.SqlSession;
import com.sun.session.SqlSessionFactory;

import java.io.IOException;
import java.util.List;

public class TestMybaits {
    public static void main(String[] args) {
        SqlSessionFactory factory = new SqlSessionFactory();
        SqlSession session = factory.openSession();
        System.out.println(session);

        UserMapper mapper = session.getMapper(UserMapper.class);

//        List<User> user = mapper.findUserList();
        User user = mapper.findUserById(1);
        System.out.println(user.toString());
    }
}
