package twophasecommit;

import org.springframework.beans.factory.annotation.Autowired;
import twophasecommit.config.TransactionConfiguration;

/**
 *
 */
public class TPCTransaction implements Transaction{

    @Autowired
    private TransactionConfiguration  transactionConfiguration;

    @Override
    public void open() {

        //获取事务ID
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
