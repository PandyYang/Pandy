package com.pandy.libreoffice;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;

import com.artofsolving.jodconverter.DocumentConverter;
import com.artofsolving.jodconverter.openoffice.connection.OpenOfficeConnection;
import com.artofsolving.jodconverter.openoffice.connection.SocketOpenOfficeConnection;
import com.artofsolving.jodconverter.openoffice.converter.OpenOfficeDocumentConverter;

public class Convert {
    public static int office2PDF(String sourceFile, String destFile) {
        String OpenOffice_HOME = "C:\\Program Files\\LibreOffice\\";
        Process pro = null;

        try {
            File inputFile = new File(sourceFile);
            if (!inputFile.exists()) {
                return -1;// 找不到源文件, 则返回-1
            }
            // 如果目标路径不存在, 则新建该路径
            File outputFile = new File(destFile);
            if (!outputFile.getParentFile().exists()) {
                outputFile.getParentFile().mkdirs();
            }
            // 启动OpenOffice的服务
            String command = OpenOffice_HOME
                    + "program\\soffice.exe -headless -accept=\"socket,host=127.0.0.1,port=8100;urp;StarOffice.ServiceManager\" -nofirststartwizard";
            pro = Runtime.getRuntime().exec(command);
            // connect to an OpenOffice.org instance running on port 8100
            OpenOfficeConnection connection = new SocketOpenOfficeConnection("127.0.0.1", 8100);
            //OpenOfficeConnection connection = new SocketOpenOfficeConnection(8100);
            connection.connect();

            // convert
            DocumentConverter converter = new OpenOfficeDocumentConverter(connection);
            converter.convert(inputFile, outputFile);
            //converter.convert(inputFile,xml,outputFile,pdf);

            // close the connection
            connection.disconnect();
            // 封闭OpenOffice服务的进程
            pro.destroy();

            return 0;
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            return -1;
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            pro.destroy();
        }

        return 1;
    }


    public static void main(String[] args) {
        String sourceFile = "D:\\yyy.txt";
        String destFile = "D:\\yyy.pdf";
        int i = office2PDF(sourceFile, destFile);
        System.out.println("------------------" + i);
    }

}
