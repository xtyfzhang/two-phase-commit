package twophasecommit;


public abstract class PCTransactionManager implements TransactionManager{

    /**
     * 获取事务ID,如果存在有效事务未提交，返回-1；
     * @return
     */
    abstract Long getTransactionId();


}