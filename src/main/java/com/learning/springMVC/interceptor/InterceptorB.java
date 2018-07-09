package com.learning.springMVC.interceptor;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class InterceptorB implements HandlerInterceptor{

    /**
     * 返回值表示是否需要把当前请求拦截下来
     *
     * 若返回false，则请求将被终止
     * 若返回true，则请求会被继续运行
     *
     * Object是指被拦截的请求的目标对象
     * */
    @Override
    public boolean preHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse,
                             Object o) throws Exception {

        System.out.println("InterceptorB preHandler");
        return true;
    }

    /**
     * 通过ModelAndView参数来改变显示的视图，或修改发往视图的方法
     * */
    @Override
    public void postHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse,
                           Object o, ModelAndView modelAndView) throws Exception {

        System.out.println("InterceptorB postHandle");
    }

    /**
     * 在请求已被响应之后，即在视图已被显示之后执行
     * 主要用于对资源的销毁
     * */
    @Override
    public void afterCompletion(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse,
                                Object o, Exception e) throws Exception {

        System.out.println("InterceptorB afterCompletion");
    }
}
