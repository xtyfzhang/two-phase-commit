package twophasecommit;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import twophasecommit.snowflake.IdWorker;

/**
 * 事务ID配置
 */
@Configuration
public class TransactionIdConfiguration {

    /**
     * 生产Id生成器
     * @return
     */
    @Bean
    public IdWorker idWorker(){

        return new IdWorker(1,1,1);
    }

}
