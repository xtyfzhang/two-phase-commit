package twophasecommit;

/**
 * 事务管理器
 */
public interface TransactionManager {

    /**
     * 事务提交
     */
    void commit();

    /**
     * 事务回滚
     */
    void rollback();
}
