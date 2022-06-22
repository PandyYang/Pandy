package com.pandy.rabbitmq.direct;

import com.pandy.rabbitmq.utils.RabbitMQUtil;
import com.rabbitmq.client.*;

import java.io.IOException;

public class Consumer {
    public static void main(String[] args) throws IOException {

        String exchangeName = "log_direct";

        Connection connection = RabbitMQUtil.getConnection();
        Channel channel = connection.createChannel();

        // 声明交换机以及交换机类型 direct
        channel.exchangeDeclare(exchangeName, "direct");

        // 创建一个临时队列
        String queue = channel.queueDeclare().getQueue();

        // 临时队列和交换机绑定
        channel.queueBind(queue, exchangeName, "error");

        //消费消息
        channel.basicConsume(queue, true, new DefaultConsumer(channel) {
            @Override
            public void handleDelivery(String consumerTag, Envelope envelope, AMQP.BasicProperties properties, byte[] body) throws IOException {
                System.out.println("消费者0" + new String(body));
            }
        });
    }
}
