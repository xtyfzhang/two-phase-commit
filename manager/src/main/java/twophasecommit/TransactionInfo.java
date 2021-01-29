package twophasecommit;

import lombok.Data;

@Data
public class TransactionInfo {

    /**
     * 事务状态
     */
    TransactionStatus transactionStatus;

    /**
     * 事务ID
     */
    String transactionId;

}
