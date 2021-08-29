package com.pandy.netty.nio;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

/**
 * 实现拷贝功能
 */
public class NIOFileChannelReadWrite {
    public static void main(String[] args) throws IOException {
        FileInputStream fileInputStream = new FileInputStream("/Users/pandy/IdeaProjects/Pandy/src/main/java/com/pandy/netty/nio/123.txt");
        FileChannel inChannel = fileInputStream.getChannel();
        FileOutputStream fileOutputStream = new FileOutputStream("/Users/pandy/IdeaProjects/Pandy/src/main/java/com/pandy/netty/nio/321.txt");
        FileChannel outChannel = fileOutputStream.getChannel();

        ByteBuffer byteBuffer = ByteBuffer.allocate(512);
        while (true) {
            byteBuffer.clear();

            int read = inChannel.read(byteBuffer);
            System.out.println("read = " + read);
            if (read == -1) {
                break;
            }

            byteBuffer.flip();
            outChannel.write(byteBuffer);

        }
        fileInputStream.close();
        fileOutputStream.close();
    }
}
