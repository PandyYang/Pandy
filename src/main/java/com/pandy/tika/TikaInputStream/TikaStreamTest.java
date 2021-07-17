package com.pandy.tika.TikaInputStream;

import org.apache.tika.exception.TikaException;
import org.apache.tika.io.TikaInputStream;
import org.apache.tika.metadata.Metadata;
import org.apache.tika.parser.AutoDetectParser;
import org.apache.tika.parser.ParseContext;
import org.apache.tika.sax.BodyContentHandler;
import org.xml.sax.SAXException;

import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class TikaStreamTest {
    public static void main(String[] args) throws IOException, TikaException, SAXException {
        //解析后
        Path outputFile = Paths.get("C:\\Users\\123\\Downloads\\123.txt");
        PrintWriter  printWriter = new PrintWriter(Files.newOutputStream(outputFile));

        BodyContentHandler contentHandler = new BodyContentHandler(printWriter);
        //输入文件
        Path inputFiles = Paths.get("C:\\Users\\123\\Downloads\\123.ppt");
        TikaInputStream inputStream = TikaInputStream.get(inputFiles);

        AutoDetectParser parser = new AutoDetectParser();
        Metadata metadata = new Metadata();
        ParseContext parseContext = new ParseContext();



        parser.parse(inputStream, contentHandler, metadata, parseContext);
    }

}
