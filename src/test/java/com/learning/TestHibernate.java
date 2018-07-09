package com.learning;

import com.kelly.hibernate.StudentEntity;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.jdbc.Work;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;
import org.junit.*;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Date;

public class TestHibernate {

    private SessionFactory sessionFactory;
    private Session session;
    private Transaction transaction;

    @Before
    public void init() {

        /**
         * 创建注册对象
         *
         * 读取hibernate.cfg.xml文件
         */
        Configuration configuration = new Configuration().configure();

        // 创建服务注册对象
        ServiceRegistry serviceRegistry = new ServiceRegistryBuilder().applySettings(configuration.getProperties()).buildServiceRegistry();

        /**
         * 创建会话工厂对象
         *
         * 读取所有映射文件 ***.hbm.xml
         *
         * sessionFactory的创建和销毁都非常消耗资源
         * 通常一个系统内一个数据库只创建一个sessionFactory
         */
        sessionFactory = configuration.buildSessionFactory(serviceRegistry);

        /**
         * 创建会话对象
         *
         * session相当于JDBC中的Connection
         * 一个session相当于一个数据库连接对象（操作数据库的对象）
         *
         * 因为hibernate是jdbc的一个封装，
         * 所以它不建议直接使用jdbc的connection来操作数据库，
         * 而是建议通过使用session来操作数据库
         *
         * session与connection是多对一关系，
         * 每个session都有一个与之对应的connection，
         * 一个connection不同时刻可以供多个session使用
         *
         * session的方法：insert(), delete(), update(), createQuery()
         */
        session = sessionFactory.openSession();

        /**
         * 创建session的两种方法：
         * openSession 和 getCurrentSession
         *
         * 1. 使用getCurrentSession需要在hibernate.cfg.xml中配置hibernate.current_session_context_class
         * 2. openSession在事务提交或回滚之后需要手动关闭session，而getCurrentSession会自动关闭session
         * 3. openSession每次都会创建新的session对象，而getCurrentSession则使用现有的session对象（单例模式）
         * 4. 若openSession创建新session后不手动关闭的话，多次之后可能会导致数据库连接池溢出
         * */
//        session = sessionFactory.getCurrentSession();

        /**
         * 开启事务transaction
         *
         * 执行session的增删改查方法时必须开启事务，
         * 即把这些方法封装在一个事务中
         *
         * hibernate对数据的操作都是封装在事务中的，
         * 且默认是非自动提交方式
         *
         * 因此，用session保存对象时，如果不开启事务且手动提交事务，
         * 对象并不会真正保存在数据库中
         *
         * 提交事务后才可关闭session
         */
        transaction = session.beginTransaction();
    }

    @After
    public void destroy() {
        // 提交事务
        transaction.commit();
        // 关闭会话
        session.close();
        // 关闭会话工厂
        sessionFactory.close();
    }

    @Test
    public void testStudent() {
        StudentEntity student;

        student = new StudentEntity(8, "Lindan", "M", new Date(), "China");
//        student = new StudentEntity(2, "Jack", "M", new Date(), null);
//        student = new StudentEntity(3, "Sansa", "F", new Date(), "England");

        /**
         * 如果需要session不通过事务而真正操作到数据库
         * 需要设置session.doWork(),
         * 且最后需要session.flush()真正输出sql语句，
         * 从而真正作用到数据库
         * */
//        session.doWork(new Work() {
//            public void execute(Connection connection) throws SQLException {
//                System.out.println("connection has hashcode: " + connection.hashCode());
//                connection.setAutoCommit(true);
//            }
//        });

        /**
         * 保存对象进入数据库
         * 注意：如果不开启事务就不能将对象真正保存到数据库中
         */
        session.save(student);

        /**
         * 与session.doWork()一起使用
         * */
//        session.flush();
    }
}
