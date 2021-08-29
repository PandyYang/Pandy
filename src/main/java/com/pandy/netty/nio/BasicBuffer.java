package com.pandy.netty.nio;

import java.nio.IntBuffer;

/**
 * NIO的buffer
 */
public class BasicBuffer {
    public static void main(String[] args) {
        IntBuffer intBuffer = IntBuffer.allocate(5);

        intBuffer.put(10);
        intBuffer.put(11);
        intBuffer.put(12);
        intBuffer.put(13);
        intBuffer.put(14);

        // 将buffer读写切换
        intBuffer.flip();

        while (intBuffer.hasRemaining()) {
            System.out.println(intBuffer.get());
        }
    }
}
