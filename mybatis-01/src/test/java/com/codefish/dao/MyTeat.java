package com.codefish.dao;

import com.codefish.pojo.Student;
import com.codefish.pojo.Teacher;
import com.codefish.utils.MybatisUtils;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.junit.Test;

import java.util.List;

public class MyTeat {
    @Test
    public void test(){
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        TeacherMapper mapper = sqlSession.getMapper(TeacherMapper.class);

        Teacher teacher = mapper.getTeacher(1);

        System.out.println(teacher.getName());
        sqlSession.close();
    }

    @Test
    public void getStudent(){
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        StudentMapper mapper = sqlSession.getMapper(StudentMapper.class);

        List<Student> studentList = mapper.getStudent();

        for (Student student : studentList) {
            System.out.println(student);
        }
        sqlSession.close();
    }
    @Test
    public void getStudent2(){
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        StudentMapper mapper = sqlSession.getMapper(StudentMapper.class);

        List<Student> studentList = mapper.getStudent2();

        for (Student student : studentList) {
            System.out.println(student);
        }
        sqlSession.close();
    }
}
