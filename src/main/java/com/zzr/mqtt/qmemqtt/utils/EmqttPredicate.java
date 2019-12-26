package com.zzr.mqtt.qmemqtt.utils;

import com.zzr.mqtt.qmemqtt.event.MqttEvent;
import org.springframework.stereotype.Component;

/**
 * @ClassName EmqttPredicate
 * @Author zzrdark
 * @Date 2019-12-26 15:11
 * @Description TODO
 **/
@Component
public class EmqttPredicate {
    public Boolean test(MqttEvent event){
        //测试内容

        return Boolean.FALSE;
    }
}
