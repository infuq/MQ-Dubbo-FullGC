package com.infuq;

import com.infuq.facade.QueryUserInfoFacade;
import org.apache.rocketmq.client.consumer.DefaultMQPushConsumer;
import org.apache.rocketmq.client.consumer.listener.ConsumeConcurrentlyContext;
import org.apache.rocketmq.client.consumer.listener.ConsumeConcurrentlyStatus;
import org.apache.rocketmq.client.consumer.listener.MessageListenerConcurrently;
import org.apache.rocketmq.client.exception.MQClientException;
import org.apache.rocketmq.common.message.MessageExt;
import org.apache.rocketmq.common.protocol.heartbeat.MessageModel;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;


public class MQConsumer {

    public static void main(String[] args) throws MQClientException {

        ApplicationContext context = new ClassPathXmlApplicationContext("DubboConsumer.xml");
        QueryUserInfoFacade queryUserInfoFacade = context.getBean(QueryUserInfoFacade.class);

        DefaultMQPushConsumer consumer = new DefaultMQPushConsumer("consumerGroup");
        consumer.setNamesrvAddr("192.168.0.102:9876");

        consumer.subscribe("TopicTest", "*");

        consumer.setMessageModel(MessageModel.CLUSTERING);

        consumer.registerMessageListener(new MessageListenerConcurrently() {
            @Override
            public ConsumeConcurrentlyStatus consumeMessage(List<MessageExt> msgs, ConsumeConcurrentlyContext context) {

                for (MessageExt x : msgs) {
//                    System.out.println("[MQ消费者]:" + Thread.currentThread().getName() + "消费消息. msgId=" + x.getMsgId());

                    try {

//                        byte[] tmp = new byte[2 * 1024 * 1024];

                        Object ret = queryUserInfoFacade.update("hangzhou");
//                        System.out.println("Dubbo接口调用返回值:" + ret);
                    } catch (Throwable _x) {
//                        System.out.println("Dubbo接口调用异常" + _x);
                    }

                }

                return ConsumeConcurrentlyStatus.CONSUME_SUCCESS;
            }
        });

        System.out.println("MQ消费者启动成功...");
        consumer.start();

    }

}
