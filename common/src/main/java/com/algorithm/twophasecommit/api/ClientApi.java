package com.algorithm.twophasecommit.api;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * 服务端通知客户端接口
 */
public interface ClientApi {

    /**
     * 询问执行结果，-1 ：执行失败；1：执行成功
     * @param id
     */
    int askResult(@RequestParam Long id);

    /**
     * 通知客户端事务提交
     * @param id
     */
    @PostMapping("/transactionCommit")
    void transactionCommit(@RequestParam  Long id);

    /**
     * 通知客户端事务回滚
     * @param id
     */
    @PostMapping("/transactionRollBack")
    void transactionRollBack(@RequestParam  Long id);

}
