package com.yofun.mapper;

import com.yofun.model.User;
import com.yofun.vo.UserVo;

import java.util.List;

public interface UserMapper {
    User findUserInfo();
    void insertUserInfo(User user);
    void updateUser(User user);
    User findByUserId(int id);
    List<User> queryUserByVo(UserVo userVo);
    void deleteUserById(int id);
    User findUserByName(String name);
}
