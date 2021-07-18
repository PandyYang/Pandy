package com.pandy.tika;

import lombok.SneakyThrows;
import org.apache.tika.exception.TikaException;
import org.apache.tika.metadata.Metadata;
import org.apache.tika.parser.AutoDetectParser;
import org.apache.tika.parser.ParseContext;
import org.apache.tika.parser.Parser;
import org.apache.tika.sax.ContentHandlerDecorator;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;

import java.io.*;

public class TikaChunkTest {
    final int MAXIMUM_TEXT_CHUNK_SIZE = 100 * 1024 * 1024;
    final File outputDir = new File("C:\\Users\\123\\Downloads\\tika");
    private final String pageTag = "p";
    protected int pageNumber = 0;

    public static void main(String[] args) throws TikaException, IOException, SAXException {
        TikaChunkTest tikaChunkTest = new TikaChunkTest();
        tikaChunkTest.parseFile(new File("C:\\Users\\123\\Downloads\\总结.txt"));
    }

    public void parseFile(File file) throws IOException, TikaException, SAXException {
        InputStream stream = new FileInputStream(file);
        Parser p = new AutoDetectParser();
        Metadata meta = new Metadata();
        BodyContentHandler handler = new BodyContentHandler();
        ParseContext context = new ParseContext();
        p.parse(stream, handler, meta, context);
        final FileOutputStream fileOutputStream = new FileOutputStream("D:\\迅雷下载\\xxx.txt");
        fileOutputStream.write(handler.toString().getBytes());
        fileOutputStream.close();
        stream.close();
    }

    private class BodyContentHandler extends ContentHandlerDecorator {
        private int fileNumber = -1;
        private OutputStreamWriter out = null;

        @Override
        public void startElement(String uri, String localName, String name, Attributes atts) throws SAXException {
            if (pageTag.equals(name)) {
                startPage();
            }
        }

        @Override
        public void endElement(String uri, String localName, String name) throws SAXException {
            if (pageTag.equals(name)) {
                endPage();
            }
        }


        @SneakyThrows
        @Override
        public void characters(char[] ch, int start, int length) {
            int size = 0;
            if (out == null || size + length > MAXIMUM_TEXT_CHUNK_SIZE) {
                if (out != null) out.close();
                fileNumber++;
                File f = new File(outputDir, "output-" + fileNumber + ".txt");
                out = new OutputStreamWriter(new FileOutputStream(f));
            }
            out.write(ch, start, length);
        }

        public void close() throws IOException {
            if (out != null) out.close();
        }

        protected void startPage() throws SAXException {
            pageNumber++;
        }

        protected void endPage() throws SAXException {
        }
    }
}
