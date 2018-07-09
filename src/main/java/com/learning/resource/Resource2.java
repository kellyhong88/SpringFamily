package com.learning.resource;

import java.io.IOException;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.core.io.Resource;

public class Resource2 implements ApplicationContextAware {

    private ApplicationContext applicationContext;

    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.applicationContext = applicationContext;
    }

    public void resource() throws IOException {

        // resource:config.txt
        Resource resource = applicationContext.getResource("classpath:config.txt");

        // absolute file path
        // Resource resource = applicationContext
        // .getResource("file:/Users/liuhong/Technology/workspace/kellyIDEA/src/main/java/com/kelly/resource/config.txt");

        // url
        // Resource resource = applicationContext
        // .getResource("url:http://docs.spring.io/spring/docs/current/spring-framework-reference/htmlsingle/");

        // src: (same as path of spring-*.xml)
        // Resource resource = applicationContext.getResource("config.txt");

        System.out.println(resource.getFilename());
        System.out.println(resource.contentLength());
    }

}
