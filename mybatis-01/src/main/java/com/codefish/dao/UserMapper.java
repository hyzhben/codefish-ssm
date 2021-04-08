package com.codefish.dao;

import com.codefish.pojo.User;

import java.util.List;

/**
 * @author: hyzha
 * @create: 2021-04-08 18:38
 */

public interface UserMapper {
    // 查询全部用户
    List<User> getUserList();

    // 根据ID查询用户
    User getUserById(int id);

    // 添加一个用户
    int addUser(User user);

    // 修改用户
    int updateUser(User user);

    // 删除用户
    int deleteUser(int id);
}
