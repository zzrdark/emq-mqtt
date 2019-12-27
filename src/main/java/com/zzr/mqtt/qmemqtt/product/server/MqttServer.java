package com.zzr.mqtt.qmemqtt.product.server;

import org.springframework.integration.annotation.Gateway;
import org.springframework.integration.annotation.MessagingGateway;
import org.springframework.integration.mqtt.support.MqttHeaders;
import org.springframework.messaging.handler.annotation.Header;
import org.springframework.stereotype.Component;

/**
 * @ClassName MqttServer
 * @Author zzrdark
 * @Date 2019-12-26 15:10
 * @Description TODO
 **/
@Component
@MessagingGateway(defaultRequestChannel = "mqttOutboundChannel")
public interface MqttServer {

    void sendToMqtt(@Header(MqttHeaders.TOPIC) String topic, String data);
}
