package com.pandy.netty.guide;

import io.netty.bootstrap.Bootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelOption;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioSocketChannel;

public class TimeClient {
    public static void main(String[] args) throws InterruptedException {
        String host = "127.0.0.1";
        int port = Integer.parseInt("8090");
        EventLoopGroup workerGroup = new NioEventLoopGroup();
        try {
            // 类似于ServerBootstrap除了它是一个非服务端的频道。
            Bootstrap b = new Bootstrap();
            // 只有一个EventLoopGroup 那么它即被当作boss 也被当作worker但是boss不会用于客户端
            b.group(workerGroup);
            // 创建一个客户端的SocketChannel
            b.channel(NioSocketChannel.class);
            // socket channel没有chaild option
            b.option(ChannelOption.SO_KEEPALIVE, true);
            b.handler(new ChannelInitializer<SocketChannel>() {
                @Override
                protected void initChannel(SocketChannel ch) throws Exception {
                    ch.pipeline().addLast(new TimeClientHandler());
                }
            });

            ChannelFuture f = b.connect(host, port).sync();
            f.channel().closeFuture().sync();
        } finally {
            workerGroup.shutdownGracefully();
        }
    }
}
