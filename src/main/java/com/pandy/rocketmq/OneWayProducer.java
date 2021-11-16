package com.pandy.rocketmq;

import org.apache.rocketmq.client.producer.DefaultMQProducer;
import org.apache.rocketmq.common.message.Message;

import java.nio.charset.StandardCharsets;

/**
 * 单向传播适用于中等可靠性的情况，例如日志收集。
 */
public class OneWayProducer {
    public static void main(String[] args) throws Exception {
        DefaultMQProducer producer = new DefaultMQProducer("please_rename_unique_group_name");
        producer.setNamesrvAddr("47.95.216.30:9876");
        producer.start();
        for (int i = 0; i < 100; i++) {
            Message msg = new Message("TopicTest", "TagA", ("Hello RocketMQ" + i).getBytes(StandardCharsets.UTF_8));
            producer.sendOneway(msg);
        }
        Thread.sleep(5000);
        producer.shutdown();
    }
}
