package com.learning;

import com.kelly.mybatis.Student;
import com.kelly.mybatis.StudentDAO;
import org.junit.Test;

import java.util.Date;

public class TestMybatis {

    @Test
    public void test() {
        StudentDAO studentDAO = new StudentDAO();

        studentDAO.query(4, "Blair");
        System.out.println("-------------------------------------------------------");

        studentDAO.query(5, "Jack");
        System.out.println("-------------------------------------------------------");

//        studentDAO.insert(new Student("Tom", "M", new Date(), "land"));

//        studentDAO.update(new Student(9, "Tom", "F", null, "sea"));

//        studentDAO.delete(9);

    }
}
