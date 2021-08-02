package com.pandy.rabbitmq.direct;

import com.pandy.rabbitmq.utils.RabbitMQUtil;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;

import java.io.IOException;
import java.nio.charset.StandardCharsets;

public class Provider {
    public static void main(String[] args) throws IOException {
        Connection connection = RabbitMQUtil.getConnection();
        Channel channel = connection.createChannel();

        channel.exchangeDeclare("log_direct", "direct");

        String routingkey = "error";
        channel.basicPublish("log_direct",
                routingkey,
                null,
                ("这是direct模型发布的基于route key： [" + routingkey+ "]的消息").getBytes(StandardCharsets.UTF_8));

        RabbitMQUtil.close(channel, connection);
    }
}
