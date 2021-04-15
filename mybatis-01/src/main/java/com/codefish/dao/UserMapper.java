package com.codefish.dao;

import com.codefish.pojo.User;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;
import java.util.Map;

/**
 * @author: hyzha
 * @create: 2021-04-08 18:38
 */

public interface UserMapper {
    // 查询全部用户
    List<User> getUserList();

    // 分页查询
    List<User> getUserByLimit(Map<String,Integer> map);

    // 模糊查询
    List<User> getUserLike(@Param("name") String name);

    // 根据ID查询用户
    @Select("select * from mybatis.user where id = #{id}")
    User getUserById(int id);



    // 添加一个用户
    int addUser(User user);

    // 添加用户（map）
    int addUser2(Map<String,Object> user);

    // 修改用户
    int updateUser(User user);

    // 删除用户
    int deleteUser(int id);


}
