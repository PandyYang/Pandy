package com.pandy.tika;

import org.apache.tika.exception.TikaException;
import org.apache.tika.metadata.Metadata;
import org.apache.tika.parser.AutoDetectParser;
import org.apache.tika.sax.BodyContentHandler;
import org.apache.tika.sax.ContentHandlerDecorator;
import org.apache.tika.sax.ToXMLContentHandler;
import org.apache.tika.sax.XHTMLContentHandler;
import org.apache.tika.sax.xpath.Matcher;
import org.apache.tika.sax.xpath.MatchingContentHandler;
import org.apache.tika.sax.xpath.XPathParser;
import org.xml.sax.ContentHandler;
import org.xml.sax.SAXException;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

public class ContentHandlerExample {

    protected final int MAXIMUM_TEXT_CHUNK_SIZE = 40;

    public static void main(String[] args) throws TikaException, SAXException, IOException {
        ContentHandlerExample contentHandlerExample = new ContentHandlerExample();
        contentHandlerExample.parseToPlainTextChunks();
    }

    public String parseToPlainText() throws IOException, SAXException, TikaException {
        BodyContentHandler handler = new BodyContentHandler();

        AutoDetectParser parser = new AutoDetectParser();
        Metadata metadata = new Metadata();
        try (InputStream stream = new FileInputStream("test.doc")) {
            parser.parse(stream, handler, metadata);
            return handler.toString();
        }
    }

    public String parseToHTML() throws IOException, SAXException, TikaException {
        ContentHandler handler = new ToXMLContentHandler();

        AutoDetectParser parser = new AutoDetectParser();
        Metadata metadata = new Metadata();
        try (InputStream stream = new FileInputStream("test.doc")) {
            parser.parse(stream, handler, metadata);
            return handler.toString();
        }
    }

    public String parseBodyToHTML() throws IOException, SAXException, TikaException {
        ContentHandler handler = new BodyContentHandler(
                new ToXMLContentHandler());

        AutoDetectParser parser = new AutoDetectParser();
        Metadata metadata = new Metadata();
        try (InputStream stream = new FileInputStream("test.doc")) {
            parser.parse(stream, handler, metadata);
            return handler.toString();
        }
    }

    public String parseOnePartToHTML() throws IOException, SAXException, TikaException {
        // Only get things under html -> body -> div (class=header)
        XPathParser xhtmlParser = new XPathParser("xhtml", XHTMLContentHandler.XHTML);
        Matcher divContentMatcher = xhtmlParser.parse("/xhtml:html/xhtml:body/xhtml:div/descendant::node()");
        ContentHandler handler = new MatchingContentHandler(
                new ToXMLContentHandler(), divContentMatcher);

        AutoDetectParser parser = new AutoDetectParser();
        Metadata metadata = new Metadata();
        try (InputStream stream = new FileInputStream("test2.doc")) {
            parser.parse(stream, handler, metadata);
            return handler.toString();
        }
    }

    public List<String> parseToPlainTextChunks() throws IOException, SAXException, TikaException {
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
        try (InputStream stream = new FileInputStream("C:\\Users\\123\\Downloads\\总结.txt")) {
            parser.parse(stream, handler, metadata);
            return chunks;
        }
    }
}
