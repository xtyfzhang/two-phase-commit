package twophasecommit;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.PropertySource;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication
@EnableTransactionManagement
@PropertySource(value = {"classpath:mybatis.properties"})
@MapperScan("twophasecommit.mapper")
public class ClientDemoApplication {

    public static void main(String[] args) {

        SpringApplication.run(ClientDemoApplication.class,args);
    }
}
