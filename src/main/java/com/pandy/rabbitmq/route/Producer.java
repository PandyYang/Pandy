package com.pandy.rabbitmq.route;

import com.pandy.rabbitmq.utils.RabbitMQUtil;
import com.rabbitmq.client.BuiltinExchangeType;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;

/**
 * @author: Pandy
 * @create: 2022/6/22
 * <p>
 * 路由模式：
 * 跟发布订阅模式类似，在订阅模式的基础上修改了exchange类型以及加上了路由键，如果消费者的路由键一样，
 * 其效果和发布/订阅模式一致，订阅模式是分发到所有绑定到交换机的所有队列，
 * 路由模式只分发到绑定在交换机上面指定路由键的队列，一个队列可以绑定多个不同的路由
 * <p>
 * 注意： 消息可能匹配多个消费者，但是同一个队列的中的消息不会被重复消费；
 * <p>
 * 说明： 生产者发送消息到交换机，同时定义了一个路由 routingKey，多个消费者声明多个队列，
 * 与交换机进行绑定，同时定义路由 routingKey，只有和生产者发送消息时的路由 routingKey相同的消费者才能消费数据；
 * <p>
 * 注意： 如果交换机和路由绑定后，需要修改路由就要修改交换机名称
 **/
public class Producer {

    /**
     * 定义交换机和队列名称
     */
    private static final String EXCHANGE_NAME = "direct_exchange";

    public static void main(String[] args) throws Exception {
        // 获取Channel
        Connection connection = RabbitMQUtil.getConnection();
        //获取链接通道
        Channel channel = connection.createChannel();

        /*绑定的交换机 参数1交互机名称 参数2 exchange类型 */
        channel.exchangeDeclare(EXCHANGE_NAME, BuiltinExchangeType.DIRECT);
        // 发送消息
        String message = "", sendType = "";
        for (int i = 0; i < 20; i++) {
            if (i % 2 == 0) {
                sendType = "info";
                message = "我是 info 级别的消息类型：" + i;
            } else {
                sendType = "error";
                message = "我是 error 级别的消息类型：" + i;
            }
            System.out.println("[send]：" + message + "  " + sendType);

            // 第二个参数就是路由键
            channel.basicPublish(EXCHANGE_NAME, sendType, null, message.getBytes());
        }
        System.out.println("消息发送完毕");
    }
}

