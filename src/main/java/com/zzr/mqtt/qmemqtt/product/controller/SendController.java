package com.zzr.mqtt.qmemqtt.product.controller;

import com.zzr.mqtt.qmemqtt.product.server.MqttServer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @ClassName SendController
 * @Author zzrdark
 * @Date 2019-12-26 15:43
 * @Description TODO
 **/

@RestController
@RequestMapping("/test")
public class SendController {

    @Autowired
    private MqttServer mqttServer;

    @RequestMapping("/sendMqtt.do")
    public String sendMqtt(String  sendData,@RequestHeader String topic) {
        mqttServer.sendToMqtt(topic, sendData);
        return "OK";
    }
}
