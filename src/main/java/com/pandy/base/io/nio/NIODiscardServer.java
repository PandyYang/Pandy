package com.pandy.base.io.nio;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;

/**
 * NIO的三大核心
 * channel
 * selector
 * buffer
 */
public class NIODiscardServer {
    public static void startServer() throws IOException {
        // 获取选择器
        Selector selector = Selector.open();
        // 获取通道
        ServerSocketChannel serverSocketChannel = ServerSocketChannel.open();
        // 设置为非阻塞
        serverSocketChannel.configureBlocking(false);
        // 绑定链接
        serverSocketChannel.bind(new InetSocketAddress(18899));
    }
}
