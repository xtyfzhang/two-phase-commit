package twophasecommit.feign;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * 事务服务接口，用于获取事务ID、投票阶段以及提交阶段
 */
public interface TransactionServer {

    /**
     * 获取事务ID
     * @return
     */
    @RequestMapping(value = "/transactionId",method = RequestMethod.GET)
    Long transactionId();

    /**
     * 向事务协调中心发送执行结果
     */
    @RequestMapping(value = "/commit",method = RequestMethod.POST)
    void commit(Long transactionId);

    /**
     * 向事务协调中心发送执行结果
     */
    @RequestMapping(value = "/rollback",method = RequestMethod.POST)
    void rollback(Long transactionId);

    /**
     * 向事务协调中心发送执行结果
     */
    @RequestMapping(value = "/close",method = RequestMethod.POST)
    void close(Long transactionId);
}
