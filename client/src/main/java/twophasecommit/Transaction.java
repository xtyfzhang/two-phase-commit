package twophasecommit;

public interface Transaction {

    /**
     * 开启事务
     */
    Long open();

    /**
     * 提交事务完成后，需要关闭事务
     */
    void commit();

    /**
     * 回滚事务完成后，需要关闭事务
     */
    void rollback();

    /**
     * 关闭事务
     */
    void close();
}
