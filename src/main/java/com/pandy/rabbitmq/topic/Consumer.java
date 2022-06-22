package com.pandy.rabbitmq.topic;

import com.pandy.rabbitmq.utils.RabbitMQUtil;
import com.rabbitmq.client.CancelCallback;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.DeliverCallback;

public class Consumer {

    /**
     * 设置路由匹配规则
     */
    private static final String ROUTING_KEY = "#.log";
    /**
     * 设置队列及交换机名称
     */
    private static final String QUEUE_NAME = "topic_consumer";
    private static final String EXCHANGE_NAME = "topic";

    public static void main(String[] args) throws Exception {
        // 获取Channel
        Channel channel = RabbitMQUtil.getConnection().createChannel();

        //消费者关联队列
        channel.queueDeclare(QUEUE_NAME, false, false, false, null);
        // 消费者绑定交换机 参数1 队列 参数2 交换机 参数3 routingKey
        channel.queueBind(QUEUE_NAME, EXCHANGE_NAME, ROUTING_KEY);

        // 消费队列消息的一个回调接口
        DeliverCallback deliverCallback = (consumerTag, delivery) -> {
            String message = new String(delivery.getBody());
            System.out.println("消息消费成功,内容:");
            System.out.println(message);
        };
        // 取消消费的一个回调接口   如在消费的时候队列被删除掉了
        CancelCallback cancelCallback = (consumerTag) -> {
            System.out.println("消息消费被中断");
        };

        channel.basicConsume(QUEUE_NAME, true, deliverCallback, cancelCallback);
        System.out.println("等待接收消息....");
    }
}
