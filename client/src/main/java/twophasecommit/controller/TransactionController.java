package twophasecommit.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.TransactionDefinition;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.DefaultTransactionDefinition;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import twophasecommit.TransactionContext;

/**
 * 事务确定端
 */
@RestController
public class TransactionController {

    @Autowired
    private TransactionContext transactionContext;

    @PostMapping("/commit")
    public void commit(Long transactionId){

        PlatformTransactionManager platformTransactionManager = transactionContext.getPlatformTransactionManager();
        DefaultTransactionDefinition transactionDefinition = new DefaultTransactionDefinition(TransactionDefinition.PROPAGATION_REQUIRED);
        TransactionStatus transactionStatus = platformTransactionManager.getTransaction(transactionDefinition);
        platformTransactionManager.commit(transactionStatus);
    }

    @PostMapping("/rollback")
    public void rollback(Long transactionId){

        PlatformTransactionManager platformTransactionManager = transactionContext.getPlatformTransactionManager();
        DefaultTransactionDefinition transactionDefinition = new DefaultTransactionDefinition(TransactionDefinition.PROPAGATION_REQUIRED);
        TransactionStatus transactionStatus = platformTransactionManager.getTransaction(transactionDefinition);
        platformTransactionManager.rollback(transactionStatus);
    }
}
