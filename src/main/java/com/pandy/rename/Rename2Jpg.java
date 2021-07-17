package com.pandy.common.rename;

/**
 * 用于批量重命名
 */
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;

public class Rename2Jpg {

    public static void main(String[] args) {
        try {
            readfile("E:/helijian/");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    //第一种方法是得到路径下的文件名，再通过递归调用判断。
    public static boolean readfile(String filepath)
            throws FileNotFoundException, IOException {
        try {
            File file = new File(filepath);
            if (!file.isDirectory()) {// 如果不是一个文件夹
                System.out.println("name=" + file.getName());// 得到文件名
            } else if (file.isDirectory()) {// 如果是个文件夹
                System.out.println("文件夹");
                System.out.println(file.getName());
                String[] filelist = file.list();// 得到下面所有文件（包括文件夹）
                String name="";
                for (int i = 0; i < filelist.length; i++) {// 循环每一个文件
                    File readfile = new File(filepath + "\\" + filelist[i]);
                    if (!readfile.isDirectory()) {// 如果不是文件夹 同上面的操作

                        name = readfile.getName();
                        System.out.println(filepath+name);
                        readfile.renameTo(new File(filepath+name+".jpg"));

                    } else if (readfile.isDirectory()) {// 如果是文件夹 那么就递规
                        readfile(filepath + "\\" + filelist[i]);
                    }
                }
            }
        } catch (FileNotFoundException e) {
            System.out.println("readfile()   Exception:" + e.getMessage());
        }
        return true;
    }
}
