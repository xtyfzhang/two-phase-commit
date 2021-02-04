package twophasecommit.feign;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

/**
 * 事务服务接口，用于获取事务ID、投票阶段以及提交阶段
 */
public interface TransactionServer {

    /**
     * 获取事务ID
     * @return
     */
    @GetMapping("/transactionId")
    Long transactionId();

    /**
     * 向事务协调中心发送执行结果
     */
    @PostMapping("/commit")
    void commit(Long transactionId);

    /**
     * 向事务协调中心发送执行结果
     */
    @PostMapping("/rollback")
    void rollback(Long transactionId);

    /**
     * 向事务协调中心发送执行结果
     */
    @PostMapping("/close")
    void close(Long transactionId);
}
