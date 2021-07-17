package com.pandy.tika.test;

import jdk.internal.org.xml.sax.SAXException;
import org.apache.tika.exception.TikaException;
import org.apache.tika.metadata.Metadata;
import org.apache.tika.parser.AutoDetectParser;
import org.apache.tika.sax.ContentHandlerDecorator;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class TikaStreamTest {

    //每片最大字符数
    int MAXIMUM_TEXT_CHUNK_SIZE = 100;
    OutputStreamWriter out = null;
    final FileInputStream sourceFile = new FileInputStream("C:\\Users\\123\\Downloads\\测试报告评审表-模板.docx");
    final File outputDir = new File("D:\\test\\1");

    public TikaStreamTest() throws FileNotFoundException {
    }

    public void parseToPlainTextChunks() throws IOException, SAXException, TikaException, org.xml.sax.SAXException {
        final List<String> chunks = new ArrayList<>();
        chunks.add("");
        ContentHandlerDecorator handler = new ContentHandlerDecorator() {
            @Override
            public void characters(char[] ch, int start, int length) {
                String lastChunk = chunks.get(chunks.size() - 1);
                String thisStr = new String(ch, start, length);

                if (lastChunk.length() + length > MAXIMUM_TEXT_CHUNK_SIZE) {
                    chunks.add(thisStr);
                } else {
                    chunks.set(chunks.size() - 1, lastChunk + thisStr);
                }
            }
        };

        AutoDetectParser parser = new AutoDetectParser();
        Metadata metadata = new Metadata();
        try (InputStream stream = sourceFile) {
            parser.parse(stream, handler, metadata);
            stream.close();
            int  fileNumber = 0;
            for (String chunk : chunks) {
                File f = new File(outputDir, "分片-" + fileNumber + ".txt");
                        out = new OutputStreamWriter(new FileOutputStream(f));
                        fileNumber ++;
                final FileOutputStream fileOutputStream = new FileOutputStream(f);
                fileOutputStream.write(chunk.getBytes());
            }
        }
    }

    public static void main(String[] args) throws SAXException, TikaException, org.xml.sax.SAXException, IOException {
        new TikaStreamTest().parseToPlainTextChunks();
    }
}
