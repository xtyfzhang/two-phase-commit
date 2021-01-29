package twophasecommit;

public enum TransactionStatus {

    commit(1,"提交"),
    rollback(2,"回滚"),
    nonConfirm(3,"待确认");
    ;

    private int val;

    private String desc;

    TransactionStatus(int val,String desc){

        this.val = val;
        this.desc = desc;
    }
}
