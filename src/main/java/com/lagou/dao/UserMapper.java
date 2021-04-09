package com.lagou.dao;

import com.lagou.pojo.User;

import java.util.List;

public interface UserMapper {

     User selectOne(User user);

     Integer save(User user);

     List<User> selectAll();

     Integer delete(User user);

     Integer update(User user);

}
