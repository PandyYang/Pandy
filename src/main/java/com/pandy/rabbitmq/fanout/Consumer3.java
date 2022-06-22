package com.pandy.rabbitmq.fanout;

import com.pandy.rabbitmq.utils.RabbitMQUtil;
import com.rabbitmq.client.*;

import java.io.IOException;

/**
 * @Author Pandy
 * @Date 2021/8/2 23:12
 */
public class Consumer3 {

    private static final String Queue_NAME = "consumerFanout_sms";
    private static final String Queue_NAME2 = "consumerFanout_email";
    private static final String EXCHANGE_NAME = "fanout_exchange";

    public static void main(String[] args) throws IOException {
        Connection connection = RabbitMQUtil.getConnection();

        assert connection != null;
        Channel channel = connection.createChannel();

        // 通道绑定交换机
//        channel.exchangeDeclare(EXCHANGE_NAME, "fanout");

        // 声明队列
        channel.queueDeclare(Queue_NAME, false, false, false, null);

        channel.queueDeclare(Queue_NAME2, false, false, false, null);

        // 绑定队列
        channel.queueBind(Queue_NAME, EXCHANGE_NAME, "");

        channel.queueBind(Queue_NAME2, EXCHANGE_NAME, "");

        // 消费消息
//        channel.basicConsume(Queue_NAME, true, new DefaultConsumer(channel) {
//            @Override
//            public void handleDelivery(String consumerTag, Envelope envelope, AMQP.BasicProperties properties, byte[] body) throws IOException {
//                System.out.println(new String(body));
//            }
//        });

       CancelCallback cancelCallback = (consumerTag -> {
           System.out.println("Consumer02消费消息中断");
       });

       DeliverCallback deliverCallback = ((consumerTag, message) -> {
           String s = new String(message.getBody());
           System.out.println("Consumer02消费消息成功");
           System.out.println(s);
       });

        CancelCallback cancelCallback01 = (consumerTag -> {
            System.out.println("Consumer01消费消息中断");
        });

        DeliverCallback deliverCallback01 = ((consumerTag, message) -> {
            String s = new String(message.getBody());
            System.out.println("Consumer01消费消息成功");
            System.out.println(s);
        });

       channel.basicConsume(Queue_NAME, true, deliverCallback01, cancelCallback01);
       channel.basicConsume(Queue_NAME2, true, deliverCallback, cancelCallback);

//       RabbitMQUtil.close(channel, connection);

    }
}
