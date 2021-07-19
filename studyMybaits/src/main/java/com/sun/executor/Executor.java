package com.sun.executor;

import com.sun.config.MappedStatement;

import java.util.List;

public interface Executor {
    /**
     *
     * 查询接口
     * @param ms 封装sql 语句的 mappedStatemnet 对象，里面包含了 sql 语句，resultType 等。
     * @param parameter 传入sql 参数
     * @param <E> 将数据对象转换成指定对象结果集返回
     * @return
     */
    <E> List<E> query(MappedStatement ms, Object parameter);

    int insertOrUpdate(MappedStatement statement, Object parameter);
}
