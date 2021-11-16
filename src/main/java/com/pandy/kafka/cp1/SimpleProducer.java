package com.pandy.kafka.cp1;

import org.apache.kafka.clients.consumer.KafkaConsumer;
import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.Producer;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.apache.kafka.common.serialization.StringDeserializer;
import org.apache.kafka.common.serialization.StringSerializer;

import java.util.Properties;

public class SimpleProducer {
    public static void main(String[] args) {
        //Assign topicName to string variable
        String topicName = "topic-demo";

        // create instance for properties to access producer configs
        Properties props = new Properties();

        Thread currentThread = Thread.currentThread();
        ClassLoader savedClassLoader = currentThread.getContextClassLoader();

        currentThread.setContextClassLoader(null);

        currentThread.setContextClassLoader(savedClassLoader);

        //Assign localhost id
        props.put("bootstrap.servers", "47.95.216.30:9092");

        //Set acknowledgements for producer requests.
        props.put("acks", "all");

                //If the request fails, the producer can automatically retry,
                props.put("retries", 0);

        //Specify buffer size in config
        props.put("batch.size", 16384);

        //Reduce the no of requests less than 0
        props.put("linger.ms", 1);

        //The buffer.memory controls the total amount of memory available to the producer for buffering.
        props.put("buffer.memory", 33554432);

        props.put("key.serializer",
                StringSerializer.class.getName());

        props.put("value.serializer",
                StringSerializer.class.getName());

        props.put("key.deserializer",
                StringDeserializer.class.getName());

        props.put("value.deserializer",
                StringDeserializer.class.getName());

//        KafkaProducer<String, String> producer = new KafkaProducer<String,String>(properties, new StringSerializer(), new StringSerializer());


        Producer<String, String> producer = new KafkaProducer
                <String, String>(props);

        for(int i = 0; i < 10; i++)
            producer.send(new ProducerRecord<String, String>(topicName,
                    Integer.toString(i), Integer.toString(i)));
        System.out.println("Message sent successfully");
        producer.close();
    }
}
