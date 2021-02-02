package twophasecommit.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * 事务配置，用于配置事务信息
 */
@Data
@ConfigurationProperties("spring.transaction.configuration")
@Component
public class TransactionConfiguration {

    /**
     * 事务服务管理地址
     */
    private String serverUrl;
}
