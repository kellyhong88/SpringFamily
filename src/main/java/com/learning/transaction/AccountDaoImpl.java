package com.learning.transaction;

import org.springframework.jdbc.core.support.JdbcDaoSupport;

/**
 * 转账案例的数据层/DAO层实现
 */
public class AccountDaoImpl extends JdbcDaoSupport implements AccountDao{

    public void outMoney(String out, Double money) {
        String sql = "update account set money = money - ? where name = ?";
        this.getJdbcTemplate().update(sql, money, out);
    }

    public void inMoney(String in, Double money) {
        String sql = "update account set money = money + ? where name = ?";
        this.getJdbcTemplate().update(sql, money, in);
    }
}
