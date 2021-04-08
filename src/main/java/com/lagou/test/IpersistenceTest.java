package com.lagou.test;


import com.lagou.io.Resoures;
import com.lagou.pojo.User;
import com.lagou.sqlSession.SqlSession;
import com.lagou.sqlSession.SqlSessionFactory;
import com.lagou.sqlSession.SqlSessionFactoryBuilder;
import org.dom4j.DocumentException;

import java.beans.IntrospectionException;
import java.beans.PropertyVetoException;
import java.io.IOException;

import java.io.InputStream;
import java.sql.SQLException;
import java.util.List;


public class IpersistenceTest {

    public static void main(String[] args) throws PropertyVetoException, DocumentException, SQLException, ClassNotFoundException, IntrospectionException, InstantiationException, IllegalAccessException, NoSuchFieldException, IOException {
        InputStream inputStream = Resoures.getInputStream("sqlMapperConfig.xml");
        SqlSessionFactory sqlSessionFactory = SqlSessionFactoryBuilder.build(inputStream);
        SqlSession sqlSession = sqlSessionFactory.openSession();
        User user = new User();
        user.setId(1);
        user.setName("zhangsan");
        User user1 = sqlSession.selectOne("User.selectOne", user);
        System.out.println(user1.toString());


/*        InputStream resourceAsStream = Resources.getResourceAsStream("mybatis-config.xml");
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(resourceAsStream);
        SqlSession sqlSession = sqlSessionFactory.openSession();
        StudentMapper mapper = sqlSession.getMapper(StudentMapper.class);
        User user = new User();
        user.setName("zhangsan");
        user.setId(1);
        User user1 = mapper.selectOne(user);
        System.out.println(user1.toString());

        User user2 = new User();
        user2.setId(2);
        user2.setName("lisi");
        mapper.saveUser(user2);

        sqlSession.commit();*/





    }

}
