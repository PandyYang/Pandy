package com.pandy.netty.guide;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelOption;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioServerSocketChannel;

public class DiscardServer {

    private int port;

    public DiscardServer(int port) {
        this.port = port;
    }

    public void run() {
        // 接收输入链接
        EventLoopGroup bossGroup = new NioEventLoopGroup();
        // 处理链接的流量
        EventLoopGroup workerGroup = new NioEventLoopGroup();
        try {
            // 建立服务的帮助类 避免繁琐得直接使用channel创建
            ServerBootstrap b = new ServerBootstrap();
            b.group(bossGroup, workerGroup)
                    // 实例化一个新的通道去接收传入的链接
                    .channel(NioServerSocketChannel.class)
                    // 增加新的handler处理pipeline和提取一些匿名累
                    .childHandler(new ChannelInitializer<SocketChannel>() {
                        @Override
                        protected void initChannel(SocketChannel ch) throws Exception {
                            ch.pipeline().addLast(new DiscardServerHandler());
                        }
                    })
                    // 定义特殊的参数 tcp的相关参数
                    .option(ChannelOption.SO_BACKLOG, 128)
                    // 通过父ServerChannel接收 本例中是NioSocketChannel
                    .childOption(ChannelOption.SO_KEEPALIVE, true);

            ChannelFuture f = b.bind(port).sync();
            f.channel().closeFuture().sync();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }finally {
            workerGroup.shutdownGracefully();
            bossGroup.shutdownGracefully();
        }
    }

    public static void main(String[] args) {
        int port = 8090;
        if (args.length > 0) {
            port = Integer.parseInt(args[0]);
        }
        new DiscardServer(port).run();
    }
}
