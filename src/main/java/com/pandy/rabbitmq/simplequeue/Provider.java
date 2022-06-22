package com.pandy.rabbitmq.simplequeue;

import com.pandy.rabbitmq.utils.RabbitMQUtil;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.MessageProperties;
import org.junit.Test;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

/**
 * 简单队列模式
 * 由生产者通过直接将消息发送给消费者
 */

public class Provider {

    //生成消息
    @Test
    public void testSendMessage() throws IOException, TimeoutException {

//        // 创建链接mq的链接工厂对象
//        ConnectionFactory connectionFactory = new ConnectionFactory();
//        // 设置链接rabbitmq主机
//        connectionFactory.setHost("127.0.0.1");
//        //设置端口号
//        connectionFactory.setPort(5672);
//        //设置链接哪个虚拟主机
//        connectionFactory.setVirtualHost("/ems");
//
//        connectionFactory.setUsername("guest");
//        connectionFactory.setPassword("guest");
        //获取链接对象
//        Connection connection = connectionFactory.newConnection();
        Connection connection = RabbitMQUtil.getConnection();
        //获取链接通道
        Channel channel = connection.createChannel();
        //通道绑定对应的消息队列
        //参数1 队列名称 在队列不存在时自动创建
        //参数2 用来定义队列特性是否要持久化
        //参数3 是否独占队列
        //参数4 是否在消费完成后自动删除队列
        //参数5 附加参数
        channel.queueDeclare("hello",false,false,false,null);
        //发布消息
        //参数1 交换机名称
        //参数2 队列名称
        //参数3 传递消息额外设置
        //参数4 消息的具体内容
        channel.basicPublish("",
                "hello",
                MessageProperties.MINIMAL_PERSISTENT_BASIC, "hello world".getBytes());

        RabbitMQUtil.close(channel, connection);
//        channel.close();
//        connection.close();
    }
}
