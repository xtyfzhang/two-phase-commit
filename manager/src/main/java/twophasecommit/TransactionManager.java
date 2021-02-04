package twophasecommit;

/**
 * 事务管理器
 */
public interface TransactionManager {

    /**
     * 事务提交
     */
    void commit(Long transactionId);

    /**
     * 事务回滚
     */
    void rollback(Long transactionId);
}
