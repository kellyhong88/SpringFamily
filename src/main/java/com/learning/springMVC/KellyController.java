package com.learning.springMVC;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/kelly")
public class KellyController {

    /**
     * 响应请求：localhost:8080/kelly/hello
     * */
    @RequestMapping("/hello")
    public String helloMVC() {
        return "hello";
    }

}
