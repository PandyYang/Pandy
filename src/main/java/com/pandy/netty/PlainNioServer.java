package com.pandy.netty;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.Iterator;
import java.util.Set;

/**
 * JavaNio实现
 */
public class PlainNioServer {
    public void server(int port) throws IOException {
        ServerSocketChannel serverChannel = ServerSocketChannel.open();
        serverChannel.configureBlocking(false);
        ServerSocket ssocket = serverChannel.socket();
        InetSocketAddress address = new InetSocketAddress(port);
        ssocket.bind(address);
        Selector selector = Selector.open();
        serverChannel.register(selector, SelectionKey.OP_ACCEPT);
        ByteBuffer wrap = ByteBuffer.wrap("hi".getBytes());
        for (;;) {
            try {
                selector.select();
            }catch (IOException e) {
                e.printStackTrace();
                break;
            }
            Set<SelectionKey> readyKeys = selector.selectedKeys();
            Iterator<SelectionKey> iterator = readyKeys.iterator();
            while (iterator.hasNext()) {
                SelectionKey next = iterator.next();
                iterator.remove();
                try {
                    if (next.isAcceptable()) {
                        ServerSocketChannel server = (ServerSocketChannel) next.channel();
                        SocketChannel accept = server.accept();
                        accept.configureBlocking(false);
                        accept.register(selector, SelectionKey.OP_WRITE | SelectionKey.OP_READ, wrap.duplicate());
                        System.out.println("Accepted connection from" + accept);
                    }
                    if (next.isWritable()) {
                        SocketChannel client = (SocketChannel) next.channel();
                        ByteBuffer byteBuffer = (ByteBuffer) next.attachment();
                        while (byteBuffer.hasRemaining()) {
                            if (client.write(byteBuffer) == 0)  break;
                        }
                    }
                }catch (IOException e) {
                    next.channel();
                    try {
                        next.channel().close();
                    }catch (IOException ee) {
                        //
                    }
                }
            }
        }
    }
}
