package com.yofun.dao;

import com.yofun.mapper.UserMapper;
import com.yofun.model.User;
import com.yofun.vo.UserVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class UserDao {

    @Autowired
    UserMapper userMapper;

    public User findUserInfo() {
        return userMapper.findUserInfo();
    }

    public void insertUserInfo(User user) {
        userMapper.insertUserInfo(user);
    }

    public void updateUser(User user) {
        userMapper.updateUser(user);
    }

    public User findByUserId(int id) {
        return userMapper.findByUserId(id);
    }

    public List<User> queryUserByVo(UserVo userVo) {
        return userMapper.queryUserByVo(userVo);
    }

    public void deleteUserById(int id) {
        userMapper.deleteUserById(id);
    }
}
