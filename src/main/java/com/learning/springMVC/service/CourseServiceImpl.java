package com.learning.springMVC.service;

import com.learning.springMVC.model.Course;
import org.springframework.stereotype.Service;

/**
 * 课程的服务类实现
 */
@Service("courseService")
public class CourseServiceImpl implements CourseService {

    public Course getCourseById(Integer courseId) {

        Course course = new Course();
        course.setCourseId(courseId);
        course.setTitle("Spring MVC学习");
        course.setImagePath("resource/image/course-img.jpg");
        course.setLevel("中级");
        course.setDuration(new Long(7200));
        course.setDescription("MVC是一种Web通用开发框架，" +
                "Spring MVC是Sun公司推出的一种MVC实现，与Sun公司之前推出的Spring结合非常良好。");
        return course;
    }
}
