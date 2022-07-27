package com.pandy.rabbitmq.route;

/**
 * @author: Pandy
 * @create: 2022/6/22
 **/

import com.pandy.rabbitmq.utils.RabbitMQUtil;
import com.rabbitmq.client.CancelCallback;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.DeliverCallback;

/**
 * 两个消费者逻辑代码一样，只是绑定的队列不同和不同的路由键
 * Consumer01:"info"、"consumer_info"；Consumer02:"error"、"consumer_error"；
 */
public class Consumer01 {
    /**
     * 设置队列及交换机名称
     */
//    private static final String ROUTING_KEY = "info";
    private static final String ROUTING_KEY = "error";
    //    private static final String QUEUE_NAME = "consumer_info";
    private static final String QUEUE_NAME = "consumer_error";
    private static final String EXCHANGE_NAME = "direct_exchange";

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
            System.out.println("Consumer01(02)消息消费成功,内容:");
            System.out.println(message);
        };
        // 取消消费的一个回调接口   如在消费的时候队列被删除掉了
        CancelCallback cancelCallback = (consumerTag) -> {
            System.out.println("Consumer01(02)消息消费被中断");
        };

        channel.basicConsume(QUEUE_NAME, true, deliverCallback, cancelCallback);
        System.out.println("Consumer01(02)等待接收消息....");
    }
}

