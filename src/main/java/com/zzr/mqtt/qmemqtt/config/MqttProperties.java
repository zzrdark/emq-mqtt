package com.zzr.mqtt.qmemqtt.config;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * @author zzrdark
 */
@ConfigurationProperties(prefix = "spring.mqtt")
@Component
@Getter
@Setter
public class MqttProperties {

    private String username;

    private String password;

    private String hostUrl;

    private String clientId;

    private String defaultTopic;

    private String completionTimeout;

    private Integer keepAlive;
}