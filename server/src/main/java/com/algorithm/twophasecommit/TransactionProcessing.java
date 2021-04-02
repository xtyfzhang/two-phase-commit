package com.algorithm.twophasecommit;

public interface TransactionProcessing {

    /**
     * 提交事务
     * @param id
     */
    public void commit(Long id);

    /**
     * 回滚事务
     * @param id
     */
    public void rollback(Long id);

    /**
     * 服务出错
     */
    public void serviceError(Long id);
}
