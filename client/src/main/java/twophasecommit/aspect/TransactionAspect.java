package twophasecommit.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.beans.factory.annotation.Autowired;
import twophasecommit.TransactionContext;
import twophasecommit.annotation.TPCTransactional;

/**
 * 事务拦截器
 */
@Aspect
public class TransactionAspect {

    @Autowired
    private TransactionContext transactionContext;

    @Around("@annotation(twophasecommit.annotation.TPCTransactional)&&@annotation(tpcTransactional)")
    public Object execute(ProceedingJoinPoint pjp, TPCTransactional tpcTransactional) throws Throwable {

        // 设置事务管理器
        transactionContext.getDefaultTransactionManager();
        // 执行
        Object resultObj = pjp.proceed();


        // 返回结果
        return resultObj;
    }
}
