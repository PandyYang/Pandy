package com.pandy.netty.nio;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.util.Arrays;

public class NIOFileChannelRead {
    public static void main(String[] args) throws IOException {

        File file = new File("/Users/pandy/IdeaProjects/Pandy/src/main/java/com/pandy/netty/nio/123.txt");

        FileInputStream fileInputStream = new FileInputStream(file);
        FileChannel channel = fileInputStream.getChannel();
        ByteBuffer byteBuffer = ByteBuffer.allocate((int) file.length());
        channel.read(byteBuffer);
        System.out.println(new String(byteBuffer.array()));
    }
}
