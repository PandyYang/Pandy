package com.pandy.rabbitmq.pubsub;

import com.pandy.rabbitmq.utils.RabbitMQUtil;
import com.rabbitmq.client.*;

import java.io.IOException;

/**
 * @Author Pandy
 * @Date 2021/8/2 23:12
 */
public class Consumer {
    public static void main(String[] args) throws IOException {
        Connection connection = RabbitMQUtil.getConnection();

        assert connection != null;
        Channel channel = connection.createChannel();

        // 通道绑定交换机
        channel.exchangeDeclare("logs", "fanout");

        // 临时队列
        String queue = channel.queueDeclare().getQueue();

        //绑定交换机和队列
        channel.queueBind(queue, "logs", "");

        // 消费消息
        channel.basicConsume(queue, true, new DefaultConsumer(channel) {
            @Override
            public void handleDelivery(String consumerTag, Envelope envelope, AMQP.BasicProperties properties, byte[] body) throws IOException {
                System.out.println(new String(body));
            }
        });

    }
}
