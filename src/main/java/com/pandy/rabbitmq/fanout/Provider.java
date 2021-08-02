package com.pandy.rabbitmq.fanout;

import com.pandy.rabbitmq.utils.RabbitMQUtil;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;

import java.io.IOException;
import java.nio.charset.StandardCharsets;

/**
 * @Author Pandy
 * @Date 2021/8/2 23:08
 */
public class Provider {
    public static void main(String[] args) throws IOException {
        Connection connection = RabbitMQUtil.getConnection();
        Channel channel = connection.createChannel();

        channel.exchangeDeclare("logs", "fanout");
        channel.basicPublish("logs",
                "",
                null,
                "fanout type message".getBytes(StandardCharsets.UTF_8));

        RabbitMQUtil.close(channel, connection);
    }
}
