package com.algorithm.twophasecommit.controller;

import com.algorithm.twophasecommit.api.ServiceApi;
import org.springframework.web.bind.annotation.RestController;

/**
 * 事务处理控制器
 */
@RestController
public class TransactionProcessingController implements ServiceApi {


    @Override
    public Long getTransactionId(int serviceNum) {
        return null;
    }

    @Override
    public Long registerTransactionService(Long id) {
        return null;
    }

    @Override
    public void commit(Long id) {

    }

    @Override
    public void rollback(Long id) {

    }

    @Override
    public void serviceError(Long id) {

    }
}
