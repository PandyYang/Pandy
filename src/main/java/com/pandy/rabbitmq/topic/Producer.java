package com.pandy.rabbitmq.topic;

import com.pandy.rabbitmq.utils.RabbitMQUtil;
import com.rabbitmq.client.BuiltinExchangeType;
import com.rabbitmq.client.Channel;

/**
 * @author: Pandy
 * @create: 2022/6/22
 *
 * 主题模式：
 * 跟 routing 路由模式类似，只不过路由模式是指定固定的路由键 routingKey，而主题模式是可以模糊匹配路由routingKey，类似于SQL中 = 和 like 的关系
 *
 * 注意：消息可能匹配多个消费者，但是同一个队列的中的消息不会被重复消费；
 * 要求：
 * 要求
 * Topic 模式消息的 routing_key 不能随意写，必须满足一定的要求，它必须是一个单词列表，以 “.” 或者 “#” 分隔开。这些单词可以是任意单词，这个单词列表最多不能超过 255 个字节。
 *
 * 分隔符
 *
 * "*(星号)"：可以代替一个单词
 *
 * "#(井号)"：可以替代零个或多个单词
 *
 * 比如
 *
 * 中间带 orange 带3个单词： *.orange.*
 * 最后一个词是 rabbit 的3 个单词：*.*.rabbit
 * 以 lazy开头的多个单词lazy.#
 **/
public class Producer {

    /**
     * 定义交换机和队列名称
     */
    private static final String EXCHANGE_NAME = "topic";

    public static void main(String[] args) throws Exception {
        // 获取Channel
        Channel channel = RabbitMQUtil.getConnection().createChannel();

        /*绑定的交换机 参数1交互机名称 参数2 exchange类型 */
        channel.exchangeDeclare(EXCHANGE_NAME, BuiltinExchangeType.TOPIC);
        // 定义路由key
        String routingKey = "mq.info.log";
        String message = "topic_exchange_msg：" + routingKey;
        System.out.println("[send] = " + message);
        // 发送消息

        // 第二个参数就是路由键
        channel.basicPublish(EXCHANGE_NAME, routingKey, null, message.getBytes());
        System.out.println("消息发送完毕");
    }
}
