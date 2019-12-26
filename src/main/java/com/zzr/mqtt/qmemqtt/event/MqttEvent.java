package com.zzr.mqtt.qmemqtt.event;

import lombok.Data;
import org.springframework.context.ApplicationEvent;

/**
 * @ClassName MqttEvent
 * @Author zzrdark
 * @Date 2019-12-26 14:59
 * @Description TODO
 **/
@Data
public class MqttEvent extends ApplicationEvent {

    /**
     *
     */
    private String topic;
    /**
     * 发送的消息
     */
    private String message;

    public MqttEvent(Object source, String topic, String message) {
        super(source);
        this.topic = topic;
        this.message = message;
    }
}
