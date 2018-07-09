package com.learning.transaction;

/**
 * 转账案例的数据层/DAO层接口
 *
 * StudentDAO: Data Access Object 数据访问对象
 */
public interface AccountDao {

    void outMoney(String out, Double money);

    void inMoney(String in, Double money);
}
