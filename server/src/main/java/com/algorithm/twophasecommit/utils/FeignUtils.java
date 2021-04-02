package com.algorithm.twophasecommit.utils;

import com.algorithm.twophasecommit.api.ClientApi;
import feign.Feign;
import org.springframework.stereotype.Component;

/**
 * feign自定义服务
 */
public class FeignUtils {

    public static ClientApi createFeignService(String url,String port){

        return Feign.builder()

              //  .decoder(new GsonDecoder())

                .target(ClientApi.class, "https://api.github.com");
    }

}
