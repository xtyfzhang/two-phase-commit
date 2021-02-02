package twophasecommit.config;

import feign.Feign;
import feign.Request;
import feign.Retryer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import twophasecommit.feign.TransactionServer;

/**
 * 构建feign服务映射信息
 */
@Configuration
public class FeignBuilder {

    /**
     * 服务配置信息
     */
    @Autowired
    private TransactionConfiguration transactionConfiguration;

    /**
     * 构建事务服务端访问类
     * @return
     */
    @Bean
    public TransactionServer transactionServer(){

        return Feign.builder()
                .options(new Request.Options(1000,3500))
                .retryer(new Retryer.Default(5000,5000,3))
                .target(TransactionServer.class,transactionConfiguration.getServerUrl());
    }
}
