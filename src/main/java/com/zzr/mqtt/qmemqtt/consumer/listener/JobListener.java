package com.zzr.mqtt.qmemqtt.consumer.listener;

import com.zzr.mqtt.qmemqtt.consumer.event.MqttEvent;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * @ClassName JobListener
 * @Author zzrdark
 * @Date 2019-12-26 15:06
 * @Description TODO
 **/
@Component
@Slf4j
public class JobListener {

    private AtomicInteger atomicInteger = new AtomicInteger();

    /**
     * 监听topic
     * @param mqttEvent
     */
    @EventListener(condition = "# mqttEvent.topic.equals(T(com.zzr.mqtt.qmemqtt.defalut.utils.TopicName).ROLL_CALL_2.getValue())")
    public void onEmqttCall(MqttEvent mqttEvent){
        atomicInteger.incrementAndGet();
        /*log.info("等待"+"第"+atomicInteger.toString()+"接收到消息："+mqttEvent.getMessage());
        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }*/
        log.info("完成"+"第"+atomicInteger.toString()+"接收到消息："+mqttEvent.getMessage());

    }
    @EventListener(condition ="@ emqttPredicate.test(#mqttEvent)")
    public void onEmqttCallTest(MqttEvent mqttEvent){
        log.info("测试通过："+mqttEvent.getMessage());
    }
}
