package com.yofun.service;

import com.yofun.dao.UserDao;
import com.yofun.model.User;
import com.yofun.vo.UserVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    UserDao userDao;

    public User findUserInfo() {
        return userDao.findUserInfo();
    }

    public void insertUserInfo(User user) {
        userDao.insertUserInfo(user);
    }

    public void updateUser(User user) {
        userDao.updateUser(user);
    }

    public User findByUserId(int id) {
        return userDao.findByUserId(id);
    }

    public List<User> queryUserByVo(UserVo userVo) {
        return userDao.queryUserByVo(userVo);
    }

    public void deleteUserById(int id) {
        userDao.deleteUserById(id);
    }
}
