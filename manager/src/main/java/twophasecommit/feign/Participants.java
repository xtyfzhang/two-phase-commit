package twophasecommit.feign;

import org.springframework.web.bind.annotation.PostMapping;

public interface Participants {

    /**
     * 向参与者发送提交
     */
    @PostMapping("/commit")
    void commit(Long transactionId);

    /**
     * 向参与者发送回滚
     */
    @PostMapping("/rollback")
    void rollback(Long transactionId);
}
