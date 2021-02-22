package twophasecommit.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.beans.factory.annotation.Autowired;
import twophasecommit.TransactionContext;
import twophasecommit.annotation.TPCTransactional;
import twophasecommit.feign.TransactionServer;

/**
 * 事务拦截器
 */
@Aspect
public class TransactionAspect {

    @Autowired
    private TransactionContext transactionContext;

    @Autowired
    private TransactionServer transactionServer;

    @Around("@annotation(twophasecommit.annotation.TPCTransactional)&&@annotation(tpcTransactional)")
    public Object execute(ProceedingJoinPoint pjp, TPCTransactional tpcTransactional) throws Throwable {

        // 设置事务管理器
        transactionContext.getDefaultTransactionManager();
        Long id = transactionServer.transactionId();
        transactionContext.setTransactionId(id);
        Object resultObj = null;
        try{
            // 执行
           resultObj = pjp.proceed();
            transactionServer.commit(id);
        }catch (Exception e) {
            transactionServer.rollback(id);
        }
        // 返回结果
        return resultObj;
    }
}
