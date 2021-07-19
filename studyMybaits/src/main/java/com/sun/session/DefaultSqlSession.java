package com.sun.session;

import com.sun.bind.MapperProxy;
import com.sun.config.Configuration;
import com.sun.config.MappedStatement;
import com.sun.executor.Executor;
import com.sun.executor.SimpleExecutor;

import java.lang.reflect.Proxy;
import java.util.List;

public class DefaultSqlSession implements SqlSession{

    private final Configuration configuration;

    private Executor executor;

    public DefaultSqlSession(Configuration configuration) {
        this.configuration = configuration;
        executor = new SimpleExecutor(configuration);
    }

    @Override
    public <T> T selectOne(String statement, Object parameter) {

        List<T> selectList = this.selectList(statement,parameter);
        if(selectList == null || selectList.size() == 0){
            return null;
        }
        if(selectList.size() == 1){
            return (T) selectList.get(0);
        }else{
            throw new RuntimeException("too many result");
        }
    }

    @Override
    public <T> List<T> selectList(String statement, Object parameter) {
        MappedStatement ms = configuration.getMappedStatement().get(statement);
        // 我们的查询方法最终还是交给了 Executor 去执行，Executor 里面封装了 JDBC 操作。传入参数包含了 sql 语句和 sql 语句需要的参数。
        return executor.query(ms,parameter);
    }

    @Override
    public <T> int insert(String statement, Object parameter) {
        MappedStatement ms = configuration.getMappedStatement().get(statement);
        return executor.insertOrUpdate(ms,parameter);
    }

    @Override
    public <T> T getMapper(Class<T> type) {
        //通过动态代理生成了一个实现类，我们重点关注，动态代理的实现，它是一个 InvocationHandler，传入参数是 this，就是 sqlSession 的一个实例。
//        MapperProxy mp = ;
        //给我一个接口，还你一个实现类
        return (T) Proxy.newProxyInstance(type.getClassLoader(),new Class[]{type},new MapperProxy(this));
    }
}
