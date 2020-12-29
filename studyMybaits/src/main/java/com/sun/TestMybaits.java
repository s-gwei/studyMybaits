package com.sun;

import com.sun.mapper.UserMapper;
import com.sun.pojo.User;
import com.sun.session.SqlSession;
import com.sun.session.SqlSessionFactory;

import java.io.IOException;
import java.util.List;

public class TestMybaits {
    public static void main(String[] args) {
        //创建SqlSessionFactory工厂，连接数据库
        SqlSessionFactory factory = new SqlSessionFactory();
        //调用openSession，创建一次连接，SqlSession操作数据库
        SqlSession session = factory.openSession();
        System.out.println(session);
        //获取mapper接口
        UserMapper mapper = session.getMapper(UserMapper.class);

//        List<User> user = mapper.findUserList();
        User user = mapper.findUserById(1);
        System.out.println(user.toString());
    }
}
