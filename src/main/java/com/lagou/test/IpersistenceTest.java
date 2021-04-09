package com.lagou.test;


import com.lagou.dao.UserMapper;
import com.lagou.io.Resoures;
import com.lagou.pojo.User;
import com.lagou.sqlSession.SqlSession;
import com.lagou.sqlSession.SqlSessionFactory;
import com.lagou.sqlSession.SqlSessionFactoryBuilder;
import org.dom4j.DocumentException;
import org.junit.Before;
import org.junit.Test;

import java.beans.IntrospectionException;
import java.beans.PropertyVetoException;
import java.io.IOException;

import java.io.InputStream;
import java.sql.SQLException;
import java.util.List;


public class IpersistenceTest {

    private SqlSession sqlSession;

    @Before
    public void before() throws PropertyVetoException, DocumentException {
        InputStream inputStream = Resoures.getInputStream("sqlMapperConfig.xml");
        SqlSessionFactory sqlSessionFactory = SqlSessionFactoryBuilder.build(inputStream);
        sqlSession = sqlSessionFactory.openSession();
    }

    @Test
    public void testSaveUser(){
        User user = new User(5, "wangwu");
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        Integer count = mapper.save(user);
        System.out.println("影响行数"+count);
    }

    @Test
    public void testUpdateUser(){
        User user = new User(5, "liliu");
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        Integer count = mapper.update(user);
        System.out.println("影响行数"+count);
    }

    @Test
    public void testDelete(){
        User user = new User(5, "liliu");
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        Integer count = mapper.delete(user);
        System.out.println("影响行数"+count);
    }

}
