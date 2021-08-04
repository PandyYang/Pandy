package com.pandy.netty;

import java.io.IOException;
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class BioServer {
    public static void main(String[] args) throws IOException {
        ExecutorService newCachedThreadPool = Executors.newCachedThreadPool();

        ServerSocket serverSocket = new ServerSocket(6666);

        System.out.println("服务器启动了");

        while (true) {
            Socket socket = serverSocket.accept();

            System.out.println("连接到一个客户端");

            newCachedThreadPool.execute(new Runnable() {
                @Override
                public void run() {
                    handler(socket);
                }
            });
        }
    }

    //编写handler方法 与客户端通讯
    public static void handler(Socket socket) {
        byte[] bytes = new byte[1024];
            try {
                System.out.println("线程信息 id = " + Thread.currentThread().getId() + "名字是： " + Thread.currentThread().getName());
                InputStream inputStream = socket.getInputStream();
                while (true) {
                    int read = inputStream.read(bytes);
                    if (read != -1) {
                        System.out.println(new String(bytes, 0, read));
                    } else {
                        break;
                    }
                }
            } catch (IOException e) {
                e.printStackTrace();
            }finally {
                try {
                    socket.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
}
