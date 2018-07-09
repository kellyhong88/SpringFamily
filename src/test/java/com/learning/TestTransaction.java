package com.learning;

import com.kelly.transaction.AccountService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

@RunWith(SpringJUnit4ClassRunner.class)
//@ContextConfiguration("classpath:applicationContext.xml")
//@ContextConfiguration("classpath:applicationContext-proxy.xml")
@ContextConfiguration("classpath:applicationContext-aspectj.xml")
//@ContextConfiguration("classpath:applicationContext-annotation.xml")
//@Transactional
public class TestTransaction {

    // spring注解注入
    @Resource(name = "accountService")
    /**
     * 注入代理类
     * 因为代理类对目标类进行了增强操作（即事务控制）
     */
//    @Resource(name = "accountServiceProxy")
    private AccountService accountService;

    @Test
    public void  testTransactionCoding() {
        accountService.transfer("Will", "Eliz", 500.0);
    }

    @Test
    public void  testTransactionXML() {
        accountService.transfer("Eliz", "Will", 500.0);
    }
}
