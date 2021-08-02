package com.pandy.rabbitmq.utils;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

public class RabbitMQUtil {

    private static ConnectionFactory connectionFactory;

    static {
        connectionFactory = new ConnectionFactory();
        connectionFactory.setHost("47.95.216.30");
        connectionFactory.setPort(5672);
        connectionFactory.setVirtualHost("/ems");
        connectionFactory.setUsername("guest");
        connectionFactory.setPassword("guest");
    }

    //定义提供创建链接的方法
    public static Connection getConnection() {
//        ConnectionFactory connectionFactory = new ConnectionFactory();
//        connectionFactory.setHost("47.95.216.30");
//        connectionFactory.setPort(5672);
//        connectionFactory.setVirtualHost("/ems");
//        connectionFactory.setUsername("guest");
//        connectionFactory.setPassword("guest");
        //获取链接对象
        try {
            return connectionFactory.newConnection();
        } catch (IOException | TimeoutException e) {
            e.printStackTrace();
        }
        return null;
    }

    // 关闭通道和链接的方法
    public static void close(Channel channel, Connection connection) {
        try {
            if (channel != null)
                channel.close();
            if (connection != null)
            connection.close();
        } catch (IOException | TimeoutException e) {
            e.printStackTrace();
        }
    }
}
