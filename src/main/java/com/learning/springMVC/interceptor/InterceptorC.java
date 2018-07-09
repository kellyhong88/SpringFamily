package com.learning.springMVC.interceptor;

import org.springframework.ui.ModelMap;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.context.request.WebRequestInterceptor;

public class InterceptorC implements WebRequestInterceptor {

    @Override
    public void preHandle(WebRequest webRequest) throws Exception {

        System.out.println("InterceptorC preHandler");
    }

    @Override
    public void postHandle(WebRequest webRequest, ModelMap modelMap) throws Exception {

        System.out.println("InterceptorC postHandle");
    }

    @Override
    public void afterCompletion(WebRequest webRequest, Exception e) throws Exception {

        System.out.println("InterceptorC afterCompletion");
    }

}
