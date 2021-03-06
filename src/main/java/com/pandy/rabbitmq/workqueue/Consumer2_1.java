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

        // 创建MQ的连接 基于TCP长连接
        Connection connection = RabbitMQUtil.getConnection();

        // 创建通信信道
        assert connection != null;
        Channel channel = connection.createChannel();

        // 如果不写basicQos(1) 则自动MQ会将所有请求平均发送给所有的消费者
        //basicQos,MQ不再对消费者一次发送多个请求，而是消费者处理完一个消息后（确认后），在从队列中获取一个新的
        // 处理完一个取一个


        /**
         *第一个参数:prefetchSize消息的大小限制,0不做限制
         *第二个参数:prefetchCount一次最多推送多少消息，ack完后，再推这么多过来
         * 第三个参数:global 限流策略应用级别。true-通道channel级别限制  false-consumer级别限制
         * */
        channel.basicQos(0,1, false);

        channel.queueDeclare("work",
                true,
                false,
                false,
                null);

        //创建一个消息消费者
        //第一个参数：队列名
        //第二个参数代表是否自动确认收到消息，false代表手动编程来确认消息，这是MQ的推荐做法 //限流，autoAck一定要设置为false
        //第三个参数要传入DefaultConsumer的实现类
        channel.basicConsume("work", false, new DefaultConsumer(channel) {
                    @Override
                    public void handleDelivery(String consumerTag, Envelope envelope, AMQP.BasicProperties properties, byte[] body) throws IOException {
                        System.out.println("消费者-2 " + new String(body));
                        channel.basicAck(envelope.getDeliveryTag(), false);
                    }
                });
    }
}
