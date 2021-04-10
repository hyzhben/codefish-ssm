package com.codefish.UserDao;

import com.codefish.dao.UserMapper;
import com.codefish.pojo.User;
import com.codefish.utils.MybatisUtils;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author: hyzh
 * @create: 2021-04-08 20:25
 */

public class UserDaoTest {
    
    @Test
    public void test(){
        // 第一步：获取SqlSession对象
        SqlSession sqlSession = MybatisUtils.getSqlSession();

        try {
            // 方式一：getMapper
            UserMapper mapper = sqlSession.getMapper(UserMapper.class);
            List<User> userList = mapper.getUserList();

            // 方式二：
            //List<User> userList = sqlSession.selectList("com.codefish.dao.UserDao.getUserList");

            for (User user : userList) {
                System.out.println(user);
            }
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            sqlSession.close();
        }


    }




    @Test
    public void getUserById(){
        SqlSession sqlSession = MybatisUtils.getSqlSession();

        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        User user = mapper.getUserById(4);

        System.out.println(user);


        sqlSession.close();
    }

    // 增删改必须要提交事务
    @Test
    public void addUser(){
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        User user = new User(6,"YH","YH");
        int i = mapper.addUser(user);
        if(i>0){
            System.out.println("插入数据成功");
        }
        sqlSession.commit();
        sqlSession.close();
    }

    // 增删改必须要提交事务
    @Test
    public void addUser2(){
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);

        Map<String, Object> map = new HashMap<String,Object>();
        map.put("userid",7);
        map.put("username","username");
        map.put("userpwd","userpwd");

        int i = mapper.addUser2(map);

        if(i>0){
            System.out.println("插入数据成功");
        }
        sqlSession.commit();
        sqlSession.close();
    }
    @Test
    public void updateUser(){
        SqlSession sqlSession = MybatisUtils.getSqlSession();

        UserMapper mapper = sqlSession.getMapper(UserMapper.class);


        int i = mapper.updateUser(new User(7,"6","six"));


        if(i>0){
            System.out.println("更改数据成功");
        } else {
            System.out.println("更改数据失败");
        }


        sqlSession.commit();


        sqlSession.close();
    }

    @Test
    public void deleteUser(){
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);

        int i = mapper.deleteUser(6);
        if(i>0){
            System.out.println("删除数据成功");
        }

        sqlSession.commit();
        sqlSession.close();
    }


    @Test
    /*模糊查询*/
    public void getUserLike(){
        SqlSession sqlSession = MybatisUtils.getSqlSession();

        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        List<User> userList = mapper.getUserLike("%y%");

        for (User user : userList) {
            System.out.println(user);
        }

        sqlSession.close();



    }
}
