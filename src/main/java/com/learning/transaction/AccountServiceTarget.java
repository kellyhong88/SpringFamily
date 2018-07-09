package com.learning.transaction;

import org.springframework.transaction.annotation.Transactional;

/**
 * spring事务管理是一种aop
 */
//@Transactional
public class AccountServiceTarget implements AccountService{

    // 注入转账DAO类
    private AccountDao accountDao;

    // setter注入
    public void setAccountDao(AccountDao accountDao) {
        this.accountDao = accountDao;
    }

    public void transfer(String out, String in, Double money) {
        accountDao.outMoney(out, money);
//        int i = 1/0;
        accountDao.inMoney(in, money);
    }
}
