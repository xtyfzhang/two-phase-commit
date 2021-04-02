package com.algorithm.twophasecommit.api;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

/**
 * 调用服务端接口西悉尼
 */
@FeignClient("two-phase-commit-service")
@RequestMapping("transactionProcessing")
public interface ServiceApi {

    /**
     * 获取事务ID
     * @param serviceNum
     * @return
     */
    public Long  getTransactionId(int serviceNum);

    /**
     * 注册事务服务
     * @return 事务ID
     */
    @GetMapping("/registerTransactionService")
    public Long registerTransactionService(@RequestParam Long id);

    /**
     * 提交事务
     * @param id
     */
    @PostMapping("/commit")
    public void commit(@RequestParam Long id);

    /**
     * 回滚事务
     * @param id
     */
    @PostMapping("rollback")
    public void rollback(@RequestParam Long id);

    /**
     * 服务出错
     */
    @PostMapping("serviceError")
    public void serviceError(@RequestParam Long id);
}
