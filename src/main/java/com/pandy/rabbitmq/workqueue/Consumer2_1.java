package com.pandy.rabbitmq.workqueue;

import com.pandy.rabbitmq.utils.RabbitMQUtil;
import com.rabbitmq.client.*;

import java.io.IOException;

/**
 * @Author Pandy
 * @Date 2021/8/2 21:32
 */
public class Consumer2_1 {
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

        channel.basicConsume("work",
                true,
                new DefaultConsumer(channel) {
                    @Override
                    public void handleDelivery(String consumerTag, Envelope envelope, AMQP.BasicProperties properties, byte[] body) throws IOException {
                        System.out.println("消费者-2 " + new String(body));
                        channel.basicAck(envelope.getDeliveryTag(), false);
                    }
                });
    }
}
