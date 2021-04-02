package com.algorithm.twophasecommit;

import com.algorithm.twophasecommit.enums.TransactionStatus;
import com.algorithm.twophasecommit.pojo.TransactionInstance;
import org.springframework.stereotype.Service;

@Service
public class TransactionProcessingService extends AbstractTransactionProcessing{


    /**
     *
     * @param id
     */
    @Override
    public void commit(Long id) {

        TransactionInstance transactionInstance = this.getTransactionInstance();
        transactionInstance.setTransactionStatus(TransactionStatus.COMMI);
        // 告知客户端事务提交

    }

    @Override
    public void rollback(Long id) {

    }

    @Override
    public void serviceError(Long id) {

    }
}
