package twophasecommit;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;
import org.springframework.transaction.PlatformTransactionManager;
import twophasecommit.enums.TransactionStage;

@Component
public class TransactionContext  {

    /**
     * spring上下文
     */
    @Autowired
    private ApplicationContext applicationContext;

    /**
     * 事务ID信息
     */
    private Long transactionId;

    /**
     * 事务处于的阶段
     */
    private TransactionStage transactionStage;

    public  PlatformTransactionManager getDefaultTransactionManager(){
        return applicationContext.getBean(PlatformTransactionManager.class);
    }

    public Long getTransactionId() {
        return transactionId;
    }

    public void setTransactionId(Long transactionId) {
        this.transactionId = transactionId;
    }

    public TransactionStage getTransactionStage() {
        return transactionStage;
    }

    public void setTransactionStage(TransactionStage transactionStage) {
        this.transactionStage = transactionStage;
    }
}
