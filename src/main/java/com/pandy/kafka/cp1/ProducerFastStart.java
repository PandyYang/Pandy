package com.pandy.kafka.cp1;

import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerRecord;

import java.util.Properties;

/**
 * 生产者客户端
 */
public class ProducerFastStart {

    public static final String brokerList = "localhost:9092";
    public static final String topic = "topic-demo";

    public static void main(String[] args) {
        Properties properties = new Properties();
        properties.put("key.serializer", "org.apache.kafka.common.serialization.StringSerializer");
        properties.put("value.serializer", "org.apache.kafka.common.serialization.StringSerializer");
        properties.put("bootstrap.servers", brokerList);
        // 配置生产者客户端参数 并创建kafkaProducer实例
        KafkaProducer<String, String> producer = new KafkaProducer<String, String>(properties);
        // 构建所需要发送的消息
        ProducerRecord<String, String> record = new ProducerRecord<>(topic, "hello kafka");

        try {
            producer.send(record);
        }catch (Exception e) {
            e.printStackTrace();
        }

        producer.close();
    }
}
