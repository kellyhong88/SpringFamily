package com.learning.springMVC.interceptor;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class InterceptorA implements HandlerInterceptor{

    /**
     * 返回值表示是否需要把当前请求拦截下来
     *
     * 若返回true，则请求会被继续运行
     * 若返回false，则请求将被终止
     *
     * Object是指被拦截的请求的目标对象
     * */
    @Override
    public boolean preHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse,
                             Object o) throws Exception {

        System.out.println("InterceptorA preHandler");

        /**
         * 相当于web.xml中过滤器filter的功能
         *
         * 拦截器interceptor和过滤器filter的区别：
         * 过滤器filter依赖于Servlet容器（如Jetty、Tomcat），基于回调函数，过滤范围较大，可过滤请求、资源等
         * 拦截器interceptor依赖于MVC框架容器（如SpringMVC、Struts），基于反射机制，只过滤请求
         * */
        httpServletRequest.setCharacterEncoding("utf-8");

        /**
         * 如果request中没有属性，则终止请求，并返回到success.jsp页面
         * */
        if (httpServletRequest.getSession().getAttributeNames() == null) {
            httpServletRequest.getRequestDispatcher("/WEB-INF/jsp/success.jsp").forward(httpServletRequest, httpServletResponse);
            return false;
        }
        return true;
    }

    /**
     * 通过ModelAndView参数来改变显示的视图，或修改发往视图的方法
     * */
    @Override
    public void postHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse,
                           Object o, ModelAndView modelAndView) throws Exception {

        System.out.println("InterceptorA postHandle");
        modelAndView.addObject("msg", "object in the postHandler method");
        modelAndView.setViewName("hello");
    }

    /**
     * 在请求已被响应之后，即在视图已被显示之后执行
     * 主要用于对资源的销毁
     * */
    @Override
    public void afterCompletion(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse,
                                Object o, Exception e) throws Exception {

        System.out.println("InterceptorA afterCompletion");
    }
}
