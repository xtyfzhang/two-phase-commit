package twophasecommit.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import twophasecommit.ServerInfo;
import twophasecommit.TPCTransactionManager;

/**
 * 事务访问端
 */
@RestController
public class TPCTransactionManagerController {

    @Autowired
    private TPCTransactionManager tpcTransactionManager;

    /**
     * 获取事务ID
     * @return
     */
    @RequestMapping("/transactionId")
    public long getTransactionId(){

        return tpcTransactionManager.getTransactionId();
    }

    /**
     * 注册参与者
     * @param serverInfo 服务信息
     */
    @PostMapping("/register")
    public void register(@RequestBody ServerInfo serverInfo){

        tpcTransactionManager.register(serverInfo);
    }

    /**
     * 提交
     */
    @PostMapping("/commit")
    public void commit(Long transactionId){

         tpcTransactionManager.commit(transactionId);
    }

    /**
     * 回滚
     */
    @PostMapping("/rollback")
    public void rollback(Long transactionId){

        tpcTransactionManager.rollback(transactionId);
    }

    /**
     * 关闭
     */
    @PostMapping("/close")
    public void close(Long transactionId){
        tpcTransactionManager.close(transactionId);
    }
}
