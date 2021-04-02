package com.algorithm.twophasecommit;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class TwoPhaseCommitApplication {

    public static void main(String[] args) {

        SpringApplication.run(TwoPhaseCommitApplication.class,args);
    }
}
