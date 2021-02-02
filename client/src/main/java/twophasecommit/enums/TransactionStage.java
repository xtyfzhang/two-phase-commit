package twophasecommit.enums;

public enum TransactionStage{

        START_PHASE(1,"开始阶段阶段"),
        VOTING_STAGE(2,"投票阶段"),
        EXECUTION_PHASE(3,"执行阶段"),
        END_PHASE(4,"结束")

        ;

        private int val;

        private String desc;

        TransactionStage(int val,String desc){

            this.val = val;
            this.desc = desc;
        }

        public int getVal(){
            return this.val;
        }

        public String getDesc(){
            return this.desc;
        }

    }