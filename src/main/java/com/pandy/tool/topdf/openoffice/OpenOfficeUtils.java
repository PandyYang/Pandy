package com.pandy.tool.topdf.openoffice;

import com.artofsolving.jodconverter.DocumentConverter;
import com.artofsolving.jodconverter.openoffice.connection.OpenOfficeConnection;
import com.artofsolving.jodconverter.openoffice.connection.SocketOpenOfficeConnection;
import com.artofsolving.jodconverter.openoffice.converter.OpenOfficeDocumentConverter;
import com.artofsolving.jodconverter.openoffice.converter.StreamOpenOfficeDocumentConverter;

import java.io.File;
import java.net.ConnectException;

public class OpenOfficeUtils {

    static final String host = "127.0.0.1";//openoffice服务地址
    static final int post = 8100;//openoffice端口号

    //计时
    public static void toPdf(String filePath, String pdfPath) {
        try {
            long old = System.currentTimeMillis();
            System.out.println("open-开始：" + filePath);
            File wordFile = new File(filePath);
            File PDFFile = new File(pdfPath);
            OpenOfficeConnection connection = new SocketOpenOfficeConnection(host, post);
            try {
                connection.connect();
                DocumentConverter converter = getConverter(host, connection);
                converter.convert(wordFile, PDFFile);
                long now = System.currentTimeMillis();
                System.out.println("open-完成：" + filePath);
                System.out.println("共耗时：" + ((now - old) / 1000.0) + "秒");
            } catch (ConnectException e) {
                System.out.println("获取OpenOffice连接失败...");
                e.printStackTrace();
            } finally {
                connection.disconnect();
            }
        } catch (Exception e) {
            System.out.println("转换失败：" + filePath);
            e.printStackTrace();
        }
    }

    private static DocumentConverter getConverter(String connectIp, OpenOfficeConnection connection) {
        DocumentConverter converter = "localhost".equals(connectIp) || "127.0.0.1".equals(connectIp)
                || "0:0:0:0:0:0:0:1".equals(connectIp) ? new OpenOfficeDocumentConverter(connection)
                : new StreamOpenOfficeDocumentConverter(connection);
        return converter;
    }

}
