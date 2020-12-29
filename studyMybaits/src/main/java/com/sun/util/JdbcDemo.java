package com.sun.util;

import java.sql.*;

public class JdbcDemo {
    public static void main(String[] args) throws SQLException {
        //声明Connection对象
        Connection con = null;
        ResultSet rs = null;
        try {
            //加载驱动程序
            Class.forName("com.mysql.jdbc.Driver");
            //创建 connection 对象
             con = DriverManager.getConnection("jdbc:mysql://localhost:3306/test","root","sungw");

            //使用 connection 对象创建statement 或者 PreparedStatement 类对象，用来执行SQL语句
            Statement statement = con.createStatement();
            //要执行的SQL语句
            String sql = "select * from t_user";
            //3.ResultSet类，用来存放获取的结果集！！
            rs = statement.executeQuery(sql);

            String userName = "";
            String id = "";
            while(rs.next()){
                //获取job这列数据
                userName = rs.getString("userName");
                //获取userId这列数据
                id = rs.getString("userId");

                //输出结果
                System.out.println(id + "\t" + userName);
            }
        } catch(ClassNotFoundException e) {
            e.printStackTrace();
        } catch(SQLException e) {
            //数据库连接失败异常处理
            e.printStackTrace();
        }catch (Exception e) {
            e.printStackTrace();
        }finally{
            rs.close();
            con.close();
        }
    }
}
