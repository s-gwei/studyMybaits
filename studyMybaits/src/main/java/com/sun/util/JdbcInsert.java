package com.sun.util;


import java.sql.*;

public class JdbcInsert {
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
            String sql = "insert into t_user (userId,sex,usrName,role) VALUES(?,?,?,?);";
            PreparedStatement statement = con.prepareStatement(sql);
            //要执行的SQL语句
            for(int i=0;i<100000000;i++){
                /**
                 * 调用实体StuInfo类,获取需要插入的各个字段的值
                 * 注意参数占位的位置
                 * 通过set方法设置参数的位置
                 * 通过get方法取参数的值
                 */
                statement.setInt(1, i);
                statement.setInt(2, 1);
                statement.setString(3,"张三"+i);
                statement.setString(4,"会员");
                statement.executeUpdate(sql);
                System.out.println("插入成功(*￣︶￣)");
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
