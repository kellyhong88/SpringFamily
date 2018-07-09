package com.learning.transaction;

import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.TransactionCallbackWithoutResult;
import org.springframework.transaction.support.TransactionTemplate;

/**
 * 转账案例的业务层实现
 */
public class AccountServiceImpl implements AccountService {

    // 注入转账DAO类
    private AccountDao accountDao;

    // setter注入
    public void setAccountDao(AccountDao accountDao) {
        this.accountDao = accountDao;
    }

    // 注入事务管理模版
    private TransactionTemplate transactionTemplate;

    // setter注入
    public void setTransactionTemplate(TransactionTemplate transactionTemplate) {
        this.transactionTemplate = transactionTemplate;
    }

    public void transfer(final String out, final String in, final Double money) {

        // TransactionCallbackWithoutResult 作为一个匿名内部类
        transactionTemplate.execute(new TransactionCallbackWithoutResult() {
            @Override
            protected void doInTransactionWithoutResult(TransactionStatus transactionStatus) {
                accountDao.outMoney(out, money);
//                int i = 1/0;
                accountDao.inMoney(in, money);
            }
        });

    }

    ;
}
