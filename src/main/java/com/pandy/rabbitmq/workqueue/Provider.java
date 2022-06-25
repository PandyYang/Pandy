package com.pandy.rabbitmq.workqueue;

import com.pandy.rabbitmq.utils.RabbitMQUtil;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.ConfirmListener;
import com.rabbitmq.client.Connection;

import java.io.IOException;

/**
 * @Author Pandy
 * @Date 2021/8/2 21:16
 *
 * RabbitMQ的Work Queue工作模式
 * 客户端生产消息 在一个队列中有两个消费者C1和C2，那么消费者之间对于同一个消息的关系是竞争的关系
 * 对于任务过重或任务较多情况使用工作队列可以提高任务处理的速度。例如：短信服务部署多个，只需要有一个节点成功发送即可
 */
public class Provider {
    public static void main(String[] args) throws IOException, InterruptedException {
        Connection connection = RabbitMQUtil.getConnection();
        assert connection != null;
        Channel channel = connection.createChannel();

        channel.confirmSelect();

        channel.queueDeclare(
                // 队列名称
                "work",
                // 是否持久化 false是持久化 mq停掉会丢数据
                true,
                // 是否队列私有化，false则代表所有消费者都可以访问，true代表只有第一次拥有它的消费者才能一直使用，其他消费者不让访问
                false,
                // 是否自动删除 false代表链接停掉不自动删除这个队列
                false,
                // 其他的额外参数
                null
        );

        // 异步确认机制
        /**
         * 实现此接口以便收到确认事件的通知。 Acks 代表消息处理成功；
         * Nacks 表示代理丢失的消息。请注意，丢失的消息仍可能已传递给消费者，
         * 但代理不能保证这一点。对于面向 lambda 的语法，请使用ConfirmCallback 。
         */
//        channel.addConfirmListener(new ConfirmListener() {
//            @Override
//            public void handleAck(long deliveryTag, boolean multiple) throws IOException {
//
//            }
//
//            @Override
//            public void handleNack(long deliveryTag, boolean multiple) throws IOException {
//
//            }
//        });

        for (int i = 0; i < 10; i++) {
            // 生产消息
            channel.basicPublish(
                    //work模式暂时不用交换机 发布订阅才会用到
                    "",
                    // 队列名称
                    "work",
                    // 额外的属性
                    null,
                    // 传递的消息字节数组
                    ( i + "hello work queue").getBytes()
            );

            // 同步确认机制
            channel.waitForConfirms();
        }

        // 批量同步
        channel.waitForConfirmsOrDie();
        RabbitMQUtil.close(channel, connection);
    }
}
