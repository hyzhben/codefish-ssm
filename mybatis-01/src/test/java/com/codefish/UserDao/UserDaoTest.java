package com.codefish.UserDao;

import com.codefish.dao.UserDao;
import com.codefish.pojo.User;
import com.codefish.utils.MybatisUtils;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.List;

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
            UserDao mapper = sqlSession.getMapper(UserDao.class);
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
    

}
