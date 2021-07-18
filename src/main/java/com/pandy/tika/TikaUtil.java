package com.pandy.tika;

import org.apache.tika.exception.TikaException;
import org.apache.tika.metadata.Metadata;
import org.apache.tika.parser.AutoDetectParser;
import org.apache.tika.parser.ParseContext;
import org.apache.tika.parser.Parser;
import org.apache.tika.sax.BodyContentHandler;
import org.xml.sax.ContentHandler;
import org.xml.sax.SAXException;

import java.io.*;

public class TikaUtil {

    /**
     * 读取文件内容
     *
     * @param file 要读取的文件
     * @return
     * @throws Exception
     */
    public static String getBody(File file) throws IOException {
        if (file == null || !file.exists()) {
            return null;
        }
        ContentHandler handler = null;
        Parser parser = new AutoDetectParser();

        InputStream input = null;
        try {
            input = new FileInputStream(file);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        Metadata meta = new Metadata();
        handler = new BodyContentHandler(-1);
        try {
            parser.parse(input, handler, meta, new ParseContext());
        } catch (IOException | SAXException | TikaException e) {
            e.printStackTrace();
        }
        if (input != null) {
            input.close();
        }
        final FileOutputStream fileOutputStream = new FileOutputStream("D:\\迅雷下载\\xxx.txt");
        fileOutputStream.write(handler.toString().getBytes());
        fileOutputStream.close();
        return "handler.toString()";
    }

    public static void main(String[] args) {
        String body = null;
        try {
//            body = getBody(new File("C:\\Users\\123\\Downloads\\123.ppt"));
            body = getBody(new File("C:\\Users\\123\\AppData\\Roaming\\LanxinSoftCustom\\Resource\\Docs\\xxx.xlsx"));

        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println(body);
    }
}
