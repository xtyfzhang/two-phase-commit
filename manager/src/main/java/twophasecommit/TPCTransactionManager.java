package twophasecommit;



import feign.Feign;
import feign.Request;
import feign.Retryer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import sun.java2d.pipe.AAShapePipe;
import twophasecommit.feign.Participants;
import twophasecommit.snowflake.IdWorker;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;

@Component
public class TPCTransactionManager extends PCTransactionManager{

    /**
     * 事务ID生成器
     */
    @Autowired
    private IdWorker idWorker;

    private volatile AtomicLong atomicLong = new AtomicLong(-1);
    /**
     * 注册的事务服务信息。
     */
    private Set<ServerInfo> serverInfos = Collections.synchronizedSet(new HashSet<>());

    /**
     * 提交的个数
     */
    private AtomicInteger commitCount = new AtomicInteger(0);

    /**
     * 回滚的个数
     */
    private AtomicInteger rollbackCount = new AtomicInteger(0);

    @Override
    public Long getTransactionId() {

        if (atomicLong.get() != -1) {
            Long transactionId = idWorker.nextId();
            atomicLong.set(transactionId);
            return transactionId;
        }
        return -1L;
    }

    /**
     * 收集参与者提交的信息
     * @param transactionId
     */
    @Override
    public void commit(Long transactionId) {

        commitCount.addAndGet(1);
    }

    /**
     * 收集参与者回滚的信息
     * @param transactionId
     */
    @Override
    public void rollback(Long transactionId) {

        rollbackCount.addAndGet(1);
    }

    /**
     * 关闭事务
     * @param transactionId 事务ID的信息
     */
    public void close(Long transactionId) {

        serverInfos.removeAll(serverInfos);
        atomicLong.set(-1);
    }

    /**
     * 注册事务参与者信息
     * @param serverInfo
     */
    public void register(ServerInfo serverInfo){

        serverInfos.add(serverInfo);
    }

    /**
     * 通知事务是否提交
     */
    public void notifition(){

        // 判断事务是否存在回滚，如果存在回滚则全部回滚
        if (rollbackCount.get() > 0) {
            // 通知所有的事务回滚
            Iterator<ServerInfo> serverInfoIterator =  serverInfos.iterator();
            while (serverInfoIterator.hasNext()) {
                Participants participants =  participants(serverInfoIterator.next());
                participants.rollback(atomicLong.get());
            }
        }

        // 判断是否所有的事务都已经成功执行
        if (commitCount.get() == serverInfos.size()) {
            // 通知所有的事务提交
            Iterator<ServerInfo> serverInfoIterator =  serverInfos.iterator();
            while (serverInfoIterator.hasNext()) {
                Participants participants =  participants(serverInfoIterator.next());
                participants.commit(atomicLong.get());
            }
        }
    }

    /**
     * 构建feign服务调用类
     * @param serverInfo
     * @return
     */
    private Participants participants(ServerInfo serverInfo){
        return Feign.builder()
                .options(new Request.Options(1000,3500))
                .retryer(new Retryer.Default(5000,5000,3))
                .target(Participants.class,"http://"+serverInfo.getServerIp() + ":" +serverInfo.getServerPort() +"/");
    }
}
