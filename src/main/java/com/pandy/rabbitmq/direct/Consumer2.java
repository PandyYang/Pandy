package com.pandy.rabbitmq.direct;

import com.pandy.rabbitmq.utils.RabbitMQUtil;
import com.rabbitmq.client.*;

import java.io.IOException;

public class Consumer2 {
    public static void main(String[] args) throws IOException {
        Connection connection = RabbitMQUtil.getConnection();
        Channel channel = connection.createChannel();

        channel.exchangeDeclare("log_direct", "direct");

        String queue = channel.queueDeclare().getQueue();

        channel.queueBind(queue, "log_direct", "error");

        channel.basicConsume(queue, true, new DefaultConsumer(channel) {
            @Override
            public void handleDelivery(String consumerTag, Envelope envelope, AMQP.BasicProperties properties, byte[] body) throws IOException {
                System.out.println("消费者1" + new String(body));
            }
        });
    }
}
