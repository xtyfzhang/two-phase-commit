package twophasecommit;

import org.springframework.beans.factory.annotation.Autowired;
import twophasecommit.snowflake.IdWorker;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class TPCTransactionManager extends PCTransactionManager{

    /**
     * 事务ID生成器
     */
    @Autowired
    private IdWorker idWorker;

    private Map<Long,String> map = new ConcurrentHashMap<>();

    /**
     * 如果存在未提交的事务，该字段值为false, 否则为true; 默认为true
     */
    private boolean isNextTransaction = true;

    @Override
    public Long getTransactionId() {

        if (isNextTransaction) {
            return idWorker.nextId();
        }
        return -1L;
    }

    @Override
    public void commit() {

    }

    @Override
    public void rollback() {

    }

    /**
     * 是否存在有效的事务。
     * @return true:存在有效的事务;false：不存在有效的事务
     */
    public boolean isExistValidTransaction(){

        return !isNextTransaction;
    }
}
