package com.learning.springMVC;

public class MVC {

    /**
     * MVC是Web开发的通用框架
     * 不仅java有用到，python和smalltalk等都有用到
     *
     * MVC本质：将业务数据的逻辑与业务数据的呈现相分离
     *
     * MVC: Model, View, Controller
     * View：视图层，为用户提供UI，关注数据的呈现
     * Model：模型层，业务数据结构，关注支撑业务的信息构成（通常是多个业务实体的组合）
     * Controller：控制层，调用业务逻辑（Service）产生合适的数据（Model），并将数据传递给视图层（View）用于呈现
     *
     * MVC是一种架构模式
     * 程序分层，分工合作，既相互独立，又协同工作
     *
     * 前端工程师：前端页面开发（客户端）
     * 后端工程师：后端逻辑开发（服务端）
     *
     * MVC是一种思考方式
     * Model层思考：需要给用户展示哪些信息，这些信息如何来构成我们的数据模型
     * View层思考： 如何对这些数据进行布局，如何以一种尽量优美、合理的方式来呈现给我们的用户
     * Controller层思考：如何设计各个业务逻辑，使得我们可以送给用户正确的数据，以及如何效率更高、性能更好
     */

    /**
     * Spring MVC是Sun公司提供的一种MVC实现
     * Spring MVC与Spring无缝结合（一家公司推出的）
     *
     * DispatcherServlet是springMVC的前端控制器（Front Controller）
     *
     * Controller用于generate Model
     * Spring中Controller的表现形式是Handler
     *
     * 在DispatcherServlet中调用的Controller是以Handler的形式出现的
     * HandlerAdapter是适配器模式，将不同类型的Handler适配成DispatcherServlet可以使用的Handler
     * (DispatcherServlet uses HandlerAdapter and HandlerAdapter knows Controller)
     *
     * HandlerInterceptor可以在Handler前后加入一些操作（aop思想）
     * (preHandler, postHandler, afterCompletion)
     *
     * Handler是DispatcherServlet调用Controller的一种中间过渡对象
     * HandlerMapping是DispatcherServlet和Controller的映射关系类
     * (HandlerMapping help DispatcherServlet to get the right Controller
     *  and wrap Controller with HandlerInterceptor into HandlerAdapter
     *  and give the HandlerAdapter to DispatcherServlet)
     *
     *  HandlerExecutionChain:
     *  preHandler -> controller method -> postHandler -> afterCompletion(this happens after rending the view)
     *
     *  ModelAndView是DispatcherServlet接受的Model
     *
     *  ViewResolver: 视图解析器
     *  help DispatcherServlet to resolve the right view to render the page
     *
     *  View: responsible for rendering pages
     */
}
