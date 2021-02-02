package twophasecommit;

import javafx.application.Application;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.TransactionDefinition;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.DefaultTransactionDefinition;
import org.springframework.transaction.support.DefaultTransactionStatus;
import twophasecommit.config.TransactionConfiguration;
import twophasecommit.enums.TransactionStage;
import twophasecommit.feign.TransactionServer;

/**
 * 事务参与者
 */
public class TPCTransaction implements Transaction{

    /**
     * 事务配置信息
     */
    @Autowired
    private TransactionConfiguration  transactionConfiguration;

    /**
     * 事务协调者方法
     */
    @Autowired
    private TransactionServer transactionServer;

    /**
     * 事务上下文信息
     */
    @Autowired
    private TransactionContext transactionContext;

    /**
     * 打开事务
     * @return
     */
    @Override
    public Long open() {

        /**
         * 存在未提交的事务，则等待事务提交之后才可以执行下一个事务
         */
        while (transactionContext.getTransactionStage() != TransactionStage.END_PHASE){
            continue;
        }
        //获取事务ID
        Long transactionId = transactionServer.transactionId();
        transactionContext.setTransactionId(transactionId);
        transactionContext.setTransactionStage(TransactionStage.START_PHASE);
        return transactionId;
    }



    @Override
    public void commit() {

        transactionContext.setTransactionStage(TransactionStage.VOTING_STAGE);
        // 通知事务协调者，执行成功，可以提交
        transactionServer.commit(transactionContext.getTransactionId());

    }

    @Override
    public void rollback() {

        transactionContext.setTransactionStage(TransactionStage.VOTING_STAGE);
        // 通知事务协调者，执行失败，需要回滚
        transactionServer.rollback(transactionContext.getTransactionId());
    }

    /**
     * 释放事务
     */
    @Override
    public void close() {

        transactionContext.setTransactionId(null);
        transactionContext.setTransactionStage(TransactionStage.END_PHASE);
        // 关闭事务
        transactionServer.close(transactionContext.getTransactionId());
    }
}
