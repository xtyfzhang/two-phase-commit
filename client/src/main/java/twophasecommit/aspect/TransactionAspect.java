package twophasecommit.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import twophasecommit.annotation.TPCTransactional;

/**
 * 事务拦截器
 */
@Aspect
public class TransactionAspect {

    @Around("@annotation(net.xdevelop.tpc.annotation.TPCTransactional)&&@annotation(tpcTransactional)")
    public Object execute(ProceedingJoinPoint pjp, TPCTransactional tpcTransactional) throws Throwable {

       //服务注册

        // 执行


        // 执行结果发送到
    }
}
