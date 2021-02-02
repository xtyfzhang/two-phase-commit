package twophasecommit;

import org.springframework.beans.factory.annotation.Autowired;
import twophasecommit.config.TransactionConfiguration;
import twophasecommit.feign.TransactionServer;

/**
 *
 */
public class TPCTransaction implements Transaction{

    @Autowired
    private TransactionConfiguration  transactionConfiguration;

    @Autowired
    private TransactionServer transactionServer;

    @Override
    public Long open() {

        //获取事务ID
        return transactionServer.transactionId();
    }



    @Override
    public void commit() {

    }

    @Override
    public void rollback() {

    }

    @Override
    public void close() {

    }
}
