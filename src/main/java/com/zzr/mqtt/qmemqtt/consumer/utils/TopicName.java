package com.zzr.mqtt.qmemqtt.consumer.utils;

/**
 * @ClassName TopicName
 * @Author zzrdark
 * @Date 2019-12-26 14:48
 * @Description TODO
 **/
public enum TopicName {

    ROLL_CALL_DEFAULT(1,"listenDefault"),
    ROLL_CALL_2(2,"hello"),
    ROLL_CALL_all(3,"broker/#");

    private final Integer key;
    private final String value;

    private TopicName(Integer key,String value){
        this.key = key;
        this.value = value;
    }
    public Integer getKey() {
        return key;
    }
    public String getValue() {
        return value;
    }

    @Override
    public String toString() {
        return this.value;
    }
}
