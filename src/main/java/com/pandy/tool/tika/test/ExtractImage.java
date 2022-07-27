//package com.pandy.tool.tika.test;
//
//import jdk.internal.org.xml.sax.SAXException;
//import org.apache.tika.exception.TikaException;
//import org.apache.tika.io.TikaInputStream;
//import org.apache.tika.metadata.Metadata;
//import org.apache.tika.parser.AutoDetectParser;
//import org.apache.tika.sax.Link;
//import org.apache.tika.sax.LinkContentHandler;
//
//import java.io.IOException;
//import java.io.InputStream;
//import java.net.URL;
//import java.util.HashSet;
//import java.util.Iterator;
//import java.util.List;
//import java.util.Set;
//
//public class ExtractImage {
//    public static void main(String[] args) throws SAXException, TikaException, org.xml.sax.SAXException, IOException {
//        new ExtractImage().extractImageLinks("https://stackoverflow.com/questions/25492907/apache-tika-read-chunk-at-a-time-from-a-file");
//    }
//
//    public void extractImageLinks(String url) throws IOException, SAXException, TikaException, org.xml.sax.SAXException {
//        Set<String> imageLinks = new HashSet<String>();
//        InputStream is = null;
//        try {
//            is = TikaInputStream.get(new URL(url).openStream());
//            Metadata metadata = new Metadata();
//            LinkContentHandler handler = new LinkContentHandler();
//            AutoDetectParser parser = new AutoDetectParser();
//            parser.parse(is, handler, metadata);
//            List<Link> links = handler.getLinks();
//            Iterator<Link> iter = links.iterator();
//            while (iter.hasNext()) {
//                Link link = iter.next();
//                if (link.isImage())
//                    imageLinks.add(link.getUri());
//            }
//        } finally {
//            is.close();
//        }
//        for (String imageLink : imageLinks) {
//            System.out.println(imageLink);
//        }
//    }
//}
