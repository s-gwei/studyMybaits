package com.sun.session;

import java.util.List;

public interface SqlSession {
    /**
     * 根据传入的条件查询单一结果
     * @param statement  namespace+id，可以用做 key，去 configuration 里面获取 sql 语句，resultType
     * @param parameter  要传入 sql 语句中的查询参数
     * @param <T> 返回指定的结果对象
     * @return
     */
    <T> T selectOne(String statement, Object parameter);
    <T> List<T> selectList(String statement, Object parameter);
    <T> int insert(String statement, Object parameter);
    <T> T getMapper(Class<T> type);
}
