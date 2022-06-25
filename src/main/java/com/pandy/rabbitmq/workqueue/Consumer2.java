package com.pandy.rabbitmq.workqueue;

import com.pandy.rabbitmq.utils.RabbitMQUtil;
import com.rabbitmq.client.*;

import java.io.IOException;

/**
 * @Author Pandy
 * @Date 2021/8/2 21:32
 */
public class Consumer2 {
    public static void main(String[] args) throws IOException {
        Connection connection = RabbitMQUtil.getConnection();
        Channel channel = connection.createChannel();

        // 能这多劳
        // 服务器将传递最大的消息数
        channel.basicQos(1);
        channel.queueDeclare("work",
                true,
                false,
                false,
                null);

        channel.queueDeclare(
                "work",
                true,
                false,
                false,
                null
        );

        // 参数1 队列名称
        // 参数2 消息自动确认机制
        channel.basicConsume("work",
                false,
                new DefaultConsumer(channel) {
                    @Override
                    public void handleDelivery(String consumerTag, Envelope envelope, AMQP.BasicProperties properties, byte[] body) throws IOException {
                        System.out.println("消费者-1 " + new String(body));
                        // 参数1 确认队列中的具体的消息
                        // 参数2 是否开启多个消息同时确认
                        channel.basicAck(envelope.getDeliveryTag(), false);
                    }
                });
    }
}
