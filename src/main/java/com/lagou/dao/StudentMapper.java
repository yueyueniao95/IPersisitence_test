package com.lagou.dao;

import com.lagou.pojo.User;

public interface StudentMapper {

    public User selectOne(User user);

    public void saveUser(User user);

}
