package com.pandy.tool.tika;

import org.apache.tika.exception.TikaException;
import org.apache.tika.metadata.Metadata;
import org.apache.tika.parser.AutoDetectParser;
import org.apache.tika.sax.ContentHandlerDecorator;
import org.xml.sax.SAXException;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class ParseToPlainTextChunks {
    public static void parseToPlainTextChunks(File file) throws IOException, SAXException, TikaException {
        int MAXIMUM_TEXT_CHUNK_SIZE = 40;
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
        try (InputStream stream = new FileInputStream(file)) {
            parser.parse(stream, handler, metadata);
            final FileOutputStream fileOutputStream = new FileOutputStream("C:\\Users\\123\\Downloads\\yyy.txt");
            fileOutputStream.write(chunks.toString().getBytes());
        }
    }

    public static void main(String[] args) throws TikaException, SAXException, IOException {
        ParseToPlainTextChunks.parseToPlainTextChunks(new File("C:\\Users\\123\\Downloads\\总结.txt"));
    }
}
