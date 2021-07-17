package com.pandy.topdf.libreoffice;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;

public class Test {

    public final Logger logger = LoggerFactory.getLogger(this.getClass());

    /**
     * 利用libreOffice将office文档转换成pdf
     *
     * @param inputFile 目标文件地址
     * @param pdfFile   输出文件夹
     * @return
     */
    public static boolean convertOffice2PDF(String inputFile, String pdfFile) {
        long start = System.currentTimeMillis();
        String command;
        boolean flag;
        String osName = System.getProperty("os.name");
        if (osName.contains("Windows")) {
            command = "cmd /c start soffice --headless --invisible --convert-to pdf:writer_pdf_Export " + inputFile + " --outdir " + pdfFile;
        } else {
            command = "com.pandy.libreoffice --headless --invisible --convert-to pdf:writer_pdf_Export " + inputFile + " --outdir " + pdfFile;
        }
        flag = executeLibreOfficeCommand(command);
        long end = System.currentTimeMillis();
        return flag;
    }


    /**
     * 执行command指令
     *
     * @param command
     * @return
     */
    public static boolean executeLibreOfficeCommand(String command) {
        Process process;// Process可以控制该子进程的执行或获取该子进程的信息
        try {
            process = Runtime.getRuntime().exec(command);// exec()方法指示Java虚拟机创建一个子进程执行指定的可执行程序，并返回与该子进程对应的Process对象实例。
            // 下面两个可以获取输入输出流
//            InputStream errorStream = process.getErrorStream();
//            InputStream inputStream = process.getInputStream();
        } catch (IOException e) {
            return false;
        }
        int exitStatus = 0;
        try {
            exitStatus = process.waitFor();// 等待子进程完成再往下执行，返回值是子线程执行完毕的返回值,返回0表示正常结束
            // 第二种接受返回值的方法
            int i = process.exitValue(); // 接收执行完毕的返回值
        } catch (InterruptedException e) {
            return false;
        }
        if (exitStatus != 0) {

        } else {

        }
        process.destroy(); // 销毁子进程
        return true;
    }

    public static void main(String[] args) {
//        convertOffice2PDF("D:\\IdeaProjects\\com.pandy.base\\src\\main\\resources\\test\\123.docx",
//                "D:\\IdeaProjects\\com.pandy.base\\src\\main\\resources\\test");
//        convertOffice2PDF("D:\\IdeaProjects\\com.pandy.base\\src\\main\\resources\\test\\wpsDoc.wps",
//                "D:\\IdeaProjects\\com.pandy.base\\src\\main\\resources\\test");
        convertOffice2PDF("D:\\IdeaProjects\\com.pandy.base\\src\\main\\resources\\test\\all\\wpsExcel.et",
                "D:\\IdeaProjects\\com.pandy.base\\src\\main\\resources\\test\\all");
//        convertOffice2PDF("D:\\IdeaProjects\\com.pandy.base\\src\\main\\resources\\test\\wpsPpt.dps",
//                "D:\\IdeaProjects\\com.pandy.base\\src\\main\\resources\\test");
//        convertOffice2PDF("D:\\IdeaProjects\\com.pandy.base\\src\\main\\resources\\test\\123.xlsx",
//                "D:\\IdeaProjects\\com.pandy.base\\src\\main\\resources\\test");
    }
}
