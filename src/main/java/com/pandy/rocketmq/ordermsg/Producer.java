package com.pandy.rocketmq.ordermsg;

import org.apache.rocketmq.client.producer.DefaultMQProducer;
import org.apache.rocketmq.client.producer.MQProducer;
import org.apache.rocketmq.client.producer.MessageQueueSelector;
import org.apache.rocketmq.client.producer.SendResult;
import org.apache.rocketmq.common.message.Message;
import org.apache.rocketmq.common.message.MessageQueue;

import java.nio.charset.StandardCharsets;
import java.util.List;

/**
 * @Author Pandy
 * @Date 2021/11/13 12:50
 */
public class Producer {
    public static void main(String[] args) throws Exception {
        MQProducer producer = new DefaultMQProducer("order-pro");
        producer.start();
        Message message = new Message("TopicTest", "消息过滤词",
                "Hello RocketMQ".getBytes(StandardCharsets.UTF_8));
        Integer hashkey = 123;
        SendResult sendResult = producer.send(message, new MessageQueueSelector() {
            @Override
            public MessageQueue select(List<MessageQueue> list, Message message, Object o) {
                Integer id = (Integer) o;
                int index = id % list.size();
                return list.get(index);
            }
        }, hashkey);
        producer.shutdown();
    }
}
