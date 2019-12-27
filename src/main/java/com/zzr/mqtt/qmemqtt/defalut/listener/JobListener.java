package com.zzr.mqtt.qmemqtt.defalut.listener;

import com.zzr.mqtt.qmemqtt.defalut.event.MqttEvent;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

/**
 * @ClassName JobListener
 * @Author zzrdark
 * @Date 2019-12-26 15:06
 * @Description TODO
 **/
@Component
@Slf4j
public class JobListener {

    /**
     * 监听topic
     * @param mqttEvent
     */
    @EventListener(condition = "# mqttEvent.topic.equals(T(com.zzr.mqtt.qmemqtt.defalut.utils.TopicName).ROLL_CALL_2.getValue())")
    public void onEmqttCall(MqttEvent mqttEvent){
        log.info("接收到消息："+mqttEvent.getMessage());
    }
    @EventListener(condition ="@ emqttPredicate.test(#mqttEvent)")
    public void onEmqttCallTest(MqttEvent mqttEvent){
        log.info("测试通过："+mqttEvent.getMessage());
    }
}
