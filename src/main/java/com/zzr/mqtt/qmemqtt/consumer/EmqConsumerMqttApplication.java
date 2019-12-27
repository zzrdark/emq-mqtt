package com.zzr.mqtt.qmemqtt.consumer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.WebApplicationType;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;

/**
 * @ClassName EmqConsumerMqttApplication
 * @Author zzrdark
 * @Date 2019-12-27 10:55
 * @Description TODO
 **/
@SpringBootApplication
public class EmqConsumerMqttApplication {

    public static void main(String[] args) {
        new SpringApplicationBuilder(EmqConsumerMqttApplication.class)
                .web(WebApplicationType.NONE)
                .run(args);
    }
}
