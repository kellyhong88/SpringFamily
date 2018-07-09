package com.learning.mybatis;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.Reader;

public class DBAccess {

    /**
     * SqlSession的作用
     * 1.向sql语句传入参数
     * 2.执行sql语句
     * 3.获取sql语句的执行结果
     * 4.事务的控制
     */
    public SqlSession getSession() throws IOException {

        /**
         * 1.通过配置文件获取数据库连接信息
         * */
        Reader reader = Resources.getResourceAsReader("mybatisConfig.xml");

        /**
         * 2.通过配置信息构建一个SqlSessionFactory
         * */
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader);

        /**
         *3.通过SqlSessionFactory开启一个数据库会话SqlSession
         * */
        SqlSession sqlSession = sqlSessionFactory.openSession();

        return sqlSession;
    }

}
