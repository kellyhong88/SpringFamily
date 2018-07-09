package com.learning.springMVC.service;

import com.learning.springMVC.model.Course;

/**
 * 课程的服务类接口
 */
public interface CourseService {

    Course getCourseById(Integer courseId);
}
