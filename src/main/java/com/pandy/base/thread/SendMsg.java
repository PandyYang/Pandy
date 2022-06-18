package com.pandy.base.thread;

import java.io.*;
import java.util.ArrayList;
import java.util.regex.Matcher;

/**
 * @author: Pandy
 * @create: 2022/6/18
 *
 * 并行发送文件 100000条
 **/
public class SendMsg {


    public static void main(String[] args) throws Exception {
        // writeMsg();
        sendMsg();
    }

    // 1-1000000短信写入文本 演示
    public static void writeMsg() throws IOException {
        File file = new File("E:\\IdeaProjects\\Pandy\\src\\main\\java\\com\\pandy\\base\\thread\\123.txt");
        FileWriter fileWriter = new FileWriter(file);

        for (int i = 0; i < 100000; i++) {
            fileWriter.write("msg" + i + "\n");
        }

        fileWriter.flush();
        fileWriter.close();
    }

    /**
     * 使用并行流 开启50个线程处理任务
     * @throws Exception
     */
    public static void sendMsg() throws Exception {
        ArrayList list = new ArrayList();
        File file = new File("E:\\IdeaProjects\\Pandy\\src\\main\\java\\com\\pandy\\base\\thread\\123.txt");
        BufferedReader reader = new BufferedReader(new FileReader(file));
        while (true) {
            String line = reader.readLine();
            if (line == null) {
                reader.close();
                break;
            } else {
                list.add(line);
            }
        }
        System.setProperty("java.util.concurrent.ForkJoinPool.common.parallelism", "50");

        File file2 = new File("E:\\IdeaProjects\\Pandy\\src\\main\\java\\com\\pandy\\base\\thread\\1234.txt");
        FileWriter fileWriter = new FileWriter(file2);



        list.parallelStream().forEach(s -> {
            try {
                fileWriter.write("当前处理短信 " + s + " 当前执行的线程为" +  Thread.currentThread().getName() + "\n");
            } catch (IOException e) {
                e.printStackTrace();
            }
            System.out.println("当前处理短信 " + s + " 当前执行的线程为" +  Thread.currentThread().getName());
        });

        fileWriter.flush();
        fileWriter.close();
    }
}
