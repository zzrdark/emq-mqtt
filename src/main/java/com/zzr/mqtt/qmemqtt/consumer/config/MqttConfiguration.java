package com.zzr.mqtt.qmemqtt.consumer.config;

import com.zzr.mqtt.qmemqtt.consumer.event.MqttEvent;
import lombok.extern.slf4j.Slf4j;
import org.eclipse.paho.client.mqttv3.MqttConnectOptions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.integration.annotation.ServiceActivator;
import org.springframework.integration.channel.DirectChannel;
import org.springframework.integration.core.MessageProducer;
import org.springframework.integration.mqtt.core.DefaultMqttPahoClientFactory;
import org.springframework.integration.mqtt.core.MqttPahoClientFactory;
import org.springframework.integration.mqtt.inbound.MqttPahoMessageDrivenChannelAdapter;
import org.springframework.integration.mqtt.support.DefaultPahoMessageConverter;
import org.springframework.messaging.Message;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.MessageHandler;

/**
 * @ClassName MqttConfiguration
 * @author zzrdark
 * @Date 2019-12-26 11:42
 * @Description TODO
 **/
@Configuration
@Slf4j
public class MqttConfiguration {

    @Autowired
    private MqttProperties mqttProperties;

    @Bean
    public MqttConnectOptions getMqttConnectOptions(){
        MqttConnectOptions mqttConnectOptions=new MqttConnectOptions();
        mqttConnectOptions.setUserName(mqttProperties.getUsername());
        mqttConnectOptions.setPassword(mqttProperties.getPassword().toCharArray());
        mqttConnectOptions.setServerURIs(new String[]{mqttProperties.getHostUrl()});
        mqttConnectOptions.setKeepAliveInterval(2);
        mqttConnectOptions.setKeepAliveInterval(mqttProperties.getKeepAlive());
        mqttConnectOptions.setAutomaticReconnect(true);

        return mqttConnectOptions;
    }
    @Bean
    public MqttPahoClientFactory mqttClientFactory() {
        DefaultMqttPahoClientFactory factory = new DefaultMqttPahoClientFactory();
        factory.setConnectionOptions(getMqttConnectOptions());
        return factory;
    }

    /**
     * 接收通道
     */
    @Bean
    public MessageChannel mqttInputChannel() {
        return new DirectChannel();
    }

    //配置client,监听的topic
    @Bean
    public MessageProducer inbound(@Autowired MessageChannel mqttInputChannel) {
        MqttPahoMessageDrivenChannelAdapter adapter =
                new MqttPahoMessageDrivenChannelAdapter(mqttProperties.getClientId()+"_inbound", mqttClientFactory(),
                        mqttProperties.getDefaultTopic(),"hello");
        adapter.setCompletionTimeout(Long.valueOf(mqttProperties.getCompletionTimeout()));
        adapter.setConverter(new DefaultPahoMessageConverter());
        adapter.setQos(1);
        adapter.setOutputChannel(mqttInputChannel);
        return adapter;
    }

    /**
     * 事件触发
     */
    @Autowired
    private ApplicationEventPublisher eventPublisher;

    //通过通道获取数据
    @Bean
    @ServiceActivator(inputChannel = "mqttInputChannel")
    public MessageHandler handler() {
        return new MessageHandler() {
            @Override
            public void handleMessage(Message<?> message) {
                String topic = message.getHeaders().get("mqtt_receivedTopic").toString();
//                String type = topic.substring(topic.lastIndexOf("/")+1, topic.length());
                String qos = message.getHeaders().get("mqtt_receivedQos").toString();
               /*if("hello".equalsIgnoreCase(topic)){
                    System.out.println("hello,fuckXX,"+message.getPayload().toString());
                }else if("hello1".equalsIgnoreCase(topic)){
                    System.out.println("hello1,fuckXX,"+message.getPayload().toString());
                }*/


//                eventPublisher.publishEvent(new MqttEvent(this,topic,message.getPayload().toString()));
                log.info("topic:"+topic+" Qos:"+qos+" message:"+message.getPayload());
            }
        };
    }

}
