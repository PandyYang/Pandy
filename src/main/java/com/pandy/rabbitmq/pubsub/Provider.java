package com.pandy.rabbitmq.pubsub;

import com.pandy.rabbitmq.utils.RabbitMQUtil;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;

import java.io.IOException;
import java.nio.charset.StandardCharsets;

/**
 * @Author Pandy
 * @Date 2021/8/2 23:08
 *
 * 发布/订阅模式是：
 * 生产者将消息发送到交换机中，由交换机发送给不同类型的消费者，做到发布一次，消费多个，
 * 如果消费者绑定的队列名称一样，将按照轮询进行消费，所以保证了：同一个队列的中的消息不会被重复消费；
 *
 * 比如：
 * 它包含一个生产者、多个消费者、两个队列和一个交换机。两个消费者同时绑定到不同的队列上去，
 * 两个队列绑定到交换机上去，生产者通过发送消息到交换机，所有消费者接收并消费消息。
 *
 * exchange类型
 * ➢ Fanout：广播，将消息交给所有绑定到交换机的队列
 * ➢ Direct：定向，把消息交给符合指定routing key 的队列
 * ➢ Topic：通配符，把消息交给符合routing pattern（路由模式） 的队列
 * ➢ Headers：参数匹配，用得少
 */
public class Provider {

    private static final String EXCHANGE_NAME = "fanout_exchange";

    public static void main(String[] args) throws IOException {

        Connection connection = RabbitMQUtil.getConnection();

        Channel channel = connection.createChannel();

        channel.exchangeDeclare(EXCHANGE_NAME, "fanout");

        for (int i = 0; i < 10; i++) {

            // routingKey设置为"", 因为fanout需要给所有的队列发送消息，所以不需要特别指定
            channel.basicPublish(EXCHANGE_NAME,
                    "",
                    null,
                    "fanout type message".getBytes(StandardCharsets.UTF_8));
        }

        RabbitMQUtil.close(channel, connection);
    }
}
