package com.codefish.dao;

import com.codefish.pojo.Blog;
import com.codefish.utils.IDUtils;
import com.codefish.utils.MybatisUtils;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.Date;
import java.util.HashMap;
import java.util.List;

public class BlogMapperTest {

    @Test
    public void addBlogTest(){
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        BlogMapper mapper = sqlSession.getMapper(BlogMapper.class);



        mapper.addBlog(new Blog(IDUtils.getId(),"入门","浅水魚",new Date(),2));
        mapper.addBlog(new Blog(IDUtils.getId(),"失败从不可怕","浅水魚",new Date(),344));
        mapper.addBlog(new Blog(IDUtils.getId(),"入门与退休","浅水狗",new Date(),55));
        mapper.addBlog(new Blog(IDUtils.getId(),"不忘初心","浅水鲨",new Date(),677));


        sqlSession.close();
    }

    @Test
    public void queryBlogIFTest(){
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        BlogMapper mapper = sqlSession.getMapper(BlogMapper.class);

        HashMap map = new HashMap();
        map.put("title","从零到一");
        map.put("author","浅水魚");

        List<Blog> blogs = mapper.queryBlogIF(map);

        for (Blog blog : blogs) {
            System.out.println(blog);
        }
        sqlSession.clearCache();// 手动清除缓存

        sqlSession.close();
    }
}
