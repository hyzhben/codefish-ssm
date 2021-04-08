package com.codefish.dao;

import com.codefish.pojo.User;

import java.util.List;

/**
 * @author: hyzha
 * @create: 2021-04-08 18:38
 */

public interface UserDao {
    List<User> getUserList();
}
