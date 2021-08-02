package com.pandy.rabbitmq.workqueue;

import com.pandy.rabbitmq.utils.RabbitMQUtil;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;

import java.io.IOException;

/**
 * @Author Pandy
 * @Date 2021/8/2 21:16
 */
public class Provider2 {
    public static void main(String[] args) throws IOException {
        Connection connection = RabbitMQUtil.getConnection();
        Channel channel = connection.createChannel();

        channel.queueDeclare(
                "work",
                true,
                false,
                false,
                null
        );

        for (int i = 0; i < 10; i++) {
            // 生产消息
            channel.basicPublish("",
                    "work",
                    null,
                    ( i + "hello work queue").getBytes()
            );
        }



        RabbitMQUtil.close(channel, connection);
    }
}
