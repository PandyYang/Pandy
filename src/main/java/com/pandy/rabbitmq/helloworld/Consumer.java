package com.pandy.rabbitmq.helloworld;

import com.pandy.rabbitmq.utils.RabbitMQUtil;
import com.rabbitmq.client.*;
import org.junit.Test;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

public class Consumer {

    @Test
    public void test() throws IOException, TimeoutException {
//        ConnectionFactory connectionFactory = new ConnectionFactory();
//        connectionFactory.setHost("127.0.0.1");
//        connectionFactory.setPort(5672);
//        connectionFactory.setVirtualHost("/ems");
//        connectionFactory.setUsername("guest");
//        connectionFactory.setPassword("guest");
//        //获取链接对象
//        Connection connection = connectionFactory.newConnection();
        //获取链接通道
        Connection connection = RabbitMQUtil.getConnection();
        Channel channel = connection.createChannel();
        channel.queueDeclare("hello",false,false,false,null);
        //消费消息
        //参数1 消费哪个队列的消息
        //参数2 开始消息自动确认机制
        //参数3 消费时的回调接口
        channel.basicConsume("hello", true,
                new DefaultConsumer(channel) {
                    @Override
                    public void handleDelivery(String consumerTag, Envelope envelope, AMQP.BasicProperties properties, byte[] body) throws IOException {
                        System.out.println("new String body" + new String(body));
                    }
                });
//        channel.close();
//        connection.close();
    }
}
