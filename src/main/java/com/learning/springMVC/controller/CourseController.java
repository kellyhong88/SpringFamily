package com.learning.springMVC.controller;

import com.learning.springMVC.model.Course;
import com.learning.springMVC.service.CourseService;
import org.apache.commons.io.FileUtils;
import org.apache.commons.lang.builder.ReflectionToStringBuilder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;

@Controller
@RequestMapping("/course")
@MultipartConfig(maxFileSize = 20971520, maxRequestSize = 20971520)
public class CourseController {

    private static Logger logger = LoggerFactory.getLogger(CourseController.class);

    /**
     * spring注解注入
     *
     * @Resource  jdk提供的，默认按照名字进行装配，byName
     * 在接口只有一个实现类时，只需在实现类上标注@Service即可
     * 但当有接口多个实现类时，则需在实现类上标注@Service("courseService")，即进行名字匹配
     *
     * @Autowired  Spring提供的，默认按照类型进行装配，byType
     * 无论接口有一个还是多个实现类，都必须匹配名字
     * 即任何时候均需在实现类上标注@Service("courseService")，进行名字的一一映射
     */
    @Resource
//    @Autowired
    private CourseService courseService;

    /**
     * 本方法将处理/course/view?courseId=123
     */
    @RequestMapping(value = "/view", method = RequestMethod.GET)
    public ModelAndView viewCourse(@RequestParam("courseId") Integer courseId, ModelAndView modelAndView) {

        Course course = courseService.getCourseById(courseId);
        logger.info(ReflectionToStringBuilder.toString(course));

        modelAndView.setViewName("course_view");
        return modelAndView;
    }

    /**
     * restful url
     * 本方法将处理/course/view/123
     */
    @GetMapping("/view/{courseId}")
    public ModelAndView viewCourse2(@PathVariable("courseId") Integer courseId, ModelAndView modelAndView) {

        Course course = courseService.getCourseById(courseId);
        logger.info(ReflectionToStringBuilder.toString(course));

        modelAndView.setViewName("course_view");
        modelAndView.addObject("msg", "object in the controller method");
        return modelAndView;
    }

    /**
     * 传统方法
     * 本方法将处理/course/viewOld?courseId=123
     */
    @RequestMapping("/viewOld")
    public String viewCourse3(HttpServletRequest request) {

        Integer courseId = new Integer(request.getParameter("courseId"));
        Course course = courseService.getCourseById(courseId);
        logger.info(ReflectionToStringBuilder.toString(course));
        return "course_view";
    }

    /**
     * restful url
     * 本方法将处理/course/create/123
     * 然后重定向到/course/view/123
     */
    @GetMapping("/create/{courseId}")
    public String createCourse(@PathVariable("courseId") Integer courseId) {

        logger.info("---------------------------------------\n" +
                "create a course: " + courseId + " and redirect to view page" +
                "\n---------------------------------------");
        return "redirect:/course/view/" + String.valueOf(courseId);
    }

    /**
     * 本方法将处理/course/upload
     */
    @RequestMapping("/upload")
    public String showUploadPage() {
        return "upload_file";
    }

    /**
     * 本方法将处理/course/doUpload
     */
    @RequestMapping(value = "/doUpload", method = RequestMethod.POST)
    public String doUpload(@RequestParam("imageFile") MultipartFile file) {

        if (!file.isEmpty()) {
            logger.info("Process file: {}", file.getOriginalFilename());
            try {
                FileUtils.copyInputStreamToFile(file.getInputStream(),
                        new File("/Users/liuhong/Technology/workspace/kellyIDEA/src/main/webapp/resources/image/",
                                System.currentTimeMillis() + "_" + file.getOriginalFilename()));
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return "success";
    }

    /**
     * restful url
     * 本方法将处理/course/json/123
     * 并且返回course的json串
     */
    @GetMapping("/json/{courseId}")
    public @ResponseBody Course getCourseJson(@PathVariable Integer courseId) {

        Course course = courseService.getCourseById(courseId);
        logger.info(ReflectionToStringBuilder.toString(course));
        return course;
    }

    /**
     * restful url
     * 本方法将处理/course/json2/123
     * 并且返回course的json串
     *
     * Spring MVC为我们提供的范型类ResponseEntity<T>
     * T是类型形参，此处传入Course作为类型实参
     */
    @GetMapping("/json2/{courseId}")
    public ResponseEntity<Course> getCourseJson2(@PathVariable Integer courseId) {

        Course course = courseService.getCourseById(courseId);
        logger.info(ReflectionToStringBuilder.toString(course));
        return new ResponseEntity<Course>(course, HttpStatus.OK);
    }

}
