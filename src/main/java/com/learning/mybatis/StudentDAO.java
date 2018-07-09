package com.learning.mybatis;

import org.apache.ibatis.session.SqlSession;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class StudentDAO {

    public List query(Integer id, String name) {
        DBAccess dbAccess = new DBAccess();
        SqlSession sqlSession = null;
        List<Student> studentList = new ArrayList<Student>();
        try {
            /**
             * 1.获取一个sqlSession
             * */
            sqlSession = dbAccess.getSession();

            /**
             * 2.通过sqlSession执行SQL语句
             * */
            System.out.println("select by Id: ");
            studentList = sqlSession.selectList("Student.queryById", id);
            for (Student student : studentList) student.print();

            System.out.println("select by name: ");
            studentList = sqlSession.selectList("Student.queryByName", name);
            for (Student student : studentList) student.print();

            System.out.println("select by id and name: ");
            Student stuCondition = new Student(id, name);
            studentList = sqlSession.selectList("Student.queryByIdAndName", stuCondition);
            for (Student student : studentList) student.print();

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (sqlSession != null) {
                sqlSession.close();
            }
        }
        return studentList;
    }

    public void insert(Student student) {
        DBAccess dbAccess = new DBAccess();
        SqlSession sqlSession = null;
        try {
            sqlSession = dbAccess.getSession();
            int count = sqlSession.insert("Student.insert", student);
            System.out.println("insert number: " + count + ", return id: " + student.getId());

            /**
             * 提交事务
             * */
            sqlSession.commit();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (sqlSession != null) {
                sqlSession.close();
            }
        }
    }

    public void update(Student student) {
        DBAccess dbAccess = new DBAccess();
        SqlSession sqlSession = null;
        try {
            sqlSession = dbAccess.getSession();
            int count = sqlSession.update("Student.update", student);
            System.out.println("update number: " + count);

            /**
             * 提交事务
             * */
            sqlSession.commit();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (sqlSession != null) {
                sqlSession.close();
            }
        }
    }

    public void delete(Integer id) {
        DBAccess dbAccess = new DBAccess();
        SqlSession sqlSession = null;
        try {
            sqlSession = dbAccess.getSession();
            int count = sqlSession.delete("Student.delete", id);
            System.out.println("delete number: " + count);

            /**
             * 提交事务
             * */
            sqlSession.commit();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (sqlSession != null) {
                sqlSession.close();
            }
        }
    }
}
