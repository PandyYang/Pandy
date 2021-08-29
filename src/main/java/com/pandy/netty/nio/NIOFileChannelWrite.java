package com.pandy.netty.nio;

import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.charset.StandardCharsets;

public class NIOFileChannelWrite {
    public static void main(String[] args) throws IOException {
        String str = "hello world!";

        // 创建输出流
        FileOutputStream fileOutputStream = new FileOutputStream("/Users/pandy/IdeaProjects/Pandy/src/main/java/com/pandy/netty/nio/123.txt");

        FileChannel channel = fileOutputStream.getChannel();

        ByteBuffer byteBuffer = ByteBuffer.allocate(1024);

        byteBuffer.put(str.getBytes(StandardCharsets.UTF_8));

        byteBuffer.flip();

        channel.write(byteBuffer);

        fileOutputStream.close();
    }
}
