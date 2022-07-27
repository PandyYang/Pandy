//package com.pandy.tool.topdf.itext;
//
//import com.itextpdf.awt.geom.AffineTransform;
//import com.itextpdf.awt.geom.Dimension;
//import com.itextpdf.awt.geom.Rectangle2D;
//import com.itextpdf.text.Chunk;
//import com.itextpdf.text.Document;
//import com.itextpdf.text.PageSize;
//import com.itextpdf.text.pdf.BaseFont;
//import com.itextpdf.text.pdf.PdfPCell;
//import com.itextpdf.text.pdf.PdfPTable;
//import com.itextpdf.text.pdf.PdfWriter;
//import org.apache.poi.xslf.usermodel.*;
//import org.apache.poi.xwpf.usermodel.*;
//
//import java.awt.*;
//import java.awt.image.BufferedImage;
//import java.io.File;
//import java.io.FileInputStream;
//import java.io.FileOutputStream;
//import java.io.IOException;
//import java.util.Iterator;
//import java.util.List;
//
//public class IText {
//    /**
//     * 返回pdf文件
//     */
//    public File convertPPTToPDF(File file, File toFile) {
//        try {
//            Document pdfDocument = new Document();
//            PdfWriter pdfWriter = PdfWriter.getInstance(pdfDocument, new FileOutputStream(toFile));
//            FileInputStream is = new FileInputStream(file);
//            double zoom = 2;
//            XMLSlideShow ppt = convertPPTToPDFByPPTX(is);
//            if (ppt == null) {
//                throw new NullPointerException("This PPTX get data is error....");
//            }
//            Dimension pgsize = ppt.getPageSize();
//            XSLFSlide[] slide = ppt.getSlides();
//            AffineTransform at = new AffineTransform();
//            at.setToScale(zoom, zoom);
//            pdfDocument.setPageSize(new com.itextpdf.text.Rectangle((float) pgsize.getWidth(), (float) pgsize.getHeight()));
//            pdfWriter.open();
//            pdfDocument.open();
//            PdfPTable table = new PdfPTable(1);
//            for (int i = 0; i < slide.length; i++) {
//                for (XSLFShape shape : slide[i].getShapes()) {
//                    if (shape instanceof XSLFTextShape) {
//                        XSLFTextShape txtshape = (XSLFTextShape) shape;
//                        for (XSLFTextParagraph textPara : txtshape.getTextParagraphs()) {
//                            List<XSLFTextRun> textRunList = textPara.getTextRuns();
//                            for (XSLFTextRun textRun : textRunList) {
//                                textRun.setFontFamily("宋体");
//                            }
//                        }
//                    }
//                }
//                BufferedImage img = new BufferedImage((int) Math.ceil(pgsize.width * zoom), (int) Math.ceil(pgsize.height * zoom), BufferedImage.TYPE_INT_RGB);
//                Graphics2D graphics = img.createGraphics();
//                graphics.setTransform(at);
//                graphics.setPaint(Color.white);
//                graphics.fill(new Rectangle2D.Float(0, 0, pgsize.width, pgsize.height));
//                slide[i].draw(graphics);
//                graphics.getPaint();
//                com.itextpdf.text.Image slideImage = Image.getInstance(img, null);
//                table.addCell(new PdfPCell(slideImage, true));
//            }
//            pdfDocument.add(table);
//            pdfDocument.close();
//            pdfWriter.close();
//            return toFile;
//        } catch (Exception e) {
//            return null;
//        }
//
//    }
//
//    private XMLSlideShow convertPPTToPDFByPPTX(FileInputStream is) {
//        try {
//            return new XMLSlideShow(is);
//        } catch (IOException e) {
//            return null;
//        }
//    }
//
//
//    /**
//     *  word to pdf
//     */
//    public File convertWordToPDF(File file, File toFile) {
//        try {package cn.hewie.pdf;
//
//import com.itextpdf.text.BaseColor;
//import com.itextpdf.text.Font;
//import com.itextpdf.text.FontProvider;
//import com.itextpdf.text.PageSize;
//import com.itextpdf.text.pdf.BaseFont;
//import com.itextpdf.text.pdf.PdfWriter;
//import com.itextpdf.tool.xml.XMLWorkerHelper;
//import org.apache.commons.lang3.StringUtils;
//import org.apache.poi.hwpf.HWPFDocument;
//import org.apache.poi.hwpf.converter.PicturesManager;
//import org.apache.poi.hwpf.converter.WordToHtmlConverter;
//import org.apache.poi.hwpf.usermodel.PictureType;
//import org.apache.poi.xwpf.converter.core.BasicURIResolver;
//import org.apache.poi.xwpf.converter.core.FileImageExtractor;
//import org.apache.poi.xwpf.converter.xhtml.XHTMLConverter;
//import org.apache.poi.xwpf.converter.xhtml.XHTMLOptions;
//import org.apache.poi.xwpf.usermodel.XWPFDocument;
//import org.jsoup.Jsoup;
//import org.jsoup.nodes.Element;
//import org.jsoup.nodes.Entities;
//import org.jsoup.select.Elements;
//import org.w3c.dom.Document;
//
//import javax.xml.parsers.DocumentBuilderFactory;
//import javax.xml.transform.OutputKeys;
//import javax.xml.transform.Transformer;
//import javax.xml.transform.TransformerFactory;
//import javax.xml.transform.dom.DOMSource;
//import javax.xml.transform.com.pandy.stream.StreamResult;
//import java.io.*;
//import java.nio.charset.Charset;
//
///**
// * 使用poi+itextpdf进行word转pdf
// * 先将word转成html，再将html转成pdf
// *
// * @author ：hewie
// * @date ：Created in 2020/2/27 22:41
// */
//public class TestPoi {
//
//    /**
//     * 将doc格式文件转成html
//     *
//     * @param docPath  doc文件路径
//     * @param imageDir doc文件中图片存储目录
//     * @return html
//     */
//    public static String doc2Html(String docPath, String imageDir) {
//        String content = null;
//        ByteArrayOutputStream baos = null;
//        try {
//            HWPFDocument wordDocument = new HWPFDocument(new FileInputStream(docPath));
//            WordToHtmlConverter wordToHtmlConverter = new WordToHtmlConverter(DocumentBuilderFactory.newInstance().newDocumentBuilder().newDocument());
//            wordToHtmlConverter.setPicturesManager(new PicturesManager() {
//                @Override
//                public String savePicture(byte[] content, PictureType pictureType, String suggestedName, float widthInches, float heightInches) {
//                    File file = new File(imageDir + suggestedName);
//                    FileOutputStream fos = null;
//                    try {
//                        fos = new FileOutputStream(file);
//                        fos.write(content);
//                    } catch (IOException e) {
//                        e.printStackTrace();
//                    } finally {
//                        try {
//                            if (fos != null) {
//                                fos.close();
//                            }
//                        } catch (Exception e) {
//                            e.printStackTrace();
//                        }
//                    }
//                    return imageDir + suggestedName;
//                }
//            });
//            wordToHtmlConverter.processDocument(wordDocument);
//            Document htmlDocument = wordToHtmlConverter.getDocument();
//            DOMSource domSource = new DOMSource(htmlDocument);
//            baos = new ByteArrayOutputStream();
//            StreamResult streamResult = new StreamResult(baos);
//
//            TransformerFactory tf = TransformerFactory.newInstance();
//            Transformer serializer = tf.newTransformer();
//            serializer.setOutputProperty(OutputKeys.ENCODING, "utf-8");
//            serializer.setOutputProperty(OutputKeys.INDENT, "yes");
//            serializer.setOutputProperty(OutputKeys.METHOD, "html");
//            serializer.transform(domSource, streamResult);
//        } catch (Exception e) {
//            e.printStackTrace();
//        } finally {
//            try {
//                if (baos != null) {
//                    content = new String(baos.toByteArray(), "utf-8");
//                    baos.close();
//                }
//            } catch (Exception e) {
//                e.printStackTrace();
//            }
//        }
//        return content;
//    }
//
//    /**
//     * 将docx格式文件转成html
//     *
//     * @param docxPath docx文件路径
//     * @param imageDir docx文件中图片存储目录
//     * @return html
//     */
//    public static String docx2Html(String docxPath, String imageDir) {
//        String content = null;
//
//        FileInputStream in = null;
//        ByteArrayOutputStream baos = null;
//        try {
//            // 1> 加载文档到XWPFDocument
//            in = new FileInputStream(new File(docxPath));
//            XWPFDocument document = new XWPFDocument(in);
//            // 2> 解析XHTML配置（这里设置IURIResolver来设置图片存放的目录）
//            XHTMLOptions options = XHTMLOptions.create();
//            // 存放word中图片的目录
//            options.setExtractor(new FileImageExtractor(new File(imageDir)));
//            options.URIResolver(new BasicURIResolver(imageDir));
//            options.setIgnoreStylesIfUnused(false);
//            options.setFragment(true);
//            // 3> 将XWPFDocument转换成XHTML
//            baos = new ByteArrayOutputStream();
//            XHTMLConverter.getInstance().convert(document, baos, options);
//        } catch (Exception e) {
//            e.printStackTrace();
//        } finally {
//            try {
//                if (in != null) {
//                    in.close();
//                }
//                if (baos != null) {
//                    content = new String(baos.toByteArray(), "utf-8");
//                    baos.close();
//                }
//            } catch (Exception e) {
//                e.printStackTrace();
//            }
//        }
//        return content;
//    }
//
//    /**
//     * 使用jsoup规范化html
//     *
//     * @param html html内容
//     * @return 规范化后的html
//     */
//    private static String formatHtml(String html) {
//        org.jsoup.nodes.Document doc = Jsoup.parse(html);
//        // 去除过大的宽度
//        String style = doc.attr("style");
//        if (StringUtils.isNotEmpty(style) && style.contains("width")) {
//            doc.attr("style", "");
//        }
//        Elements divs = doc.select("div");
//        for (Element div : divs) {
//            String divStyle = div.attr("style");
//            if (StringUtils.isNotEmpty(divStyle) && divStyle.contains("width")) {
//                div.attr("style", "");
//            }
//        }
//        // jsoup生成闭合标签
//        doc.outputSettings().syntax(org.jsoup.nodes.Document.OutputSettings.Syntax.xml);
//        doc.outputSettings().escapeMode(Entities.EscapeMode.xhtml);
//        return doc.html();
//    }
//
//
//    /**
//     * html转成pdf
//     *
//     * @param html          html
//     * @param outputPdfPath 输出pdf路径
//     */
//    private static void htmlToPdf(String html, String outputPdfPath) {
//        com.itextpdf.text.Document document = null;
//        try {
//            // 纸
//            document = new com.itextpdf.text.Document(PageSize.A4);
//            // 笔
//            PdfWriter writer = PdfWriter.getInstance(document, new FileOutputStream(outputPdfPath));
//            document.open();
//            // html转pdf
//            XMLWorkerHelper.getInstance().parseXHtml(writer, document, new ByteArrayInputStream(html.getBytes()),
//                    Charset.forName("UTF-8"), new FontProvider() {
//                        @Override
//                        public boolean isRegistered(String s) {
//                            return false;
//                        }
//
//                        @Override
//                        public Font getFont(String s, String s1, boolean embedded, float size, int style, BaseColor baseColor) {
//                            // 配置字体
//                            Font font = null;
//                            try {
//                                // 方案一：使用本地字体(本地需要有字体)
////                              BaseFont bf = BaseFont.createFont("c:/Windows/Fonts/simsun.ttc,0", BaseFont.IDENTITY_H, BaseFont.EMBEDDED);
//                                // 方案二：使用jar包：iTextAsian，这样只需一个jar包就可以了
//                                BaseFont bf = BaseFont.createFont("STSong-Light", "UniGB-UCS2-H", BaseFont.EMBEDDED);
//                                font = new Font(bf, size, style, baseColor);
//                                font.setColor(baseColor);
//                            } catch (Exception e) {
//                                e.printStackTrace();
//                            }
//                            return font;
//                        }
//                    });
//        } catch (Exception e) {
//            e.printStackTrace();
//        } finally {
//            if (document != null) {
//                document.close();
//            }
//        }
//    }
//
//    public static void main(String[] args) throws Exception {
//        String basePath = "F:/test/pdf/";
//        String docPath = basePath + "index.doc";
//        String docxPath = basePath + "index.docx";
//        String pdfPath = basePath + "index.pdf";
//        String imageDir = "F:/test/pdf/image/";
//
//        // 测试doc转pdf
////        String docHtml = doc2Html(docPath, imageDir);
////        docHtml = formatHtml(docHtml);
////        htmlToPdf(docHtml, pdfPath);
//
//        // 测试docx转pdf
//        String docxHtml = docx2Html(docxPath, imageDir);
//        docxHtml = formatHtml(docxHtml);
//        docxHtml = docxHtml.replace("___", "张三");
//        htmlToPdf(docxHtml, pdfPath);
//
//    }
//}
//            // size of pdfDocument
//            Document pdfDocument = new Document(PageSize.A3, 72, 72, 72, 72);
//            PdfWriter pdfWriter = PdfWriter.getInstance(pdfDocument, new FileOutputStream(toFile));
//            FileInputStream input_document = new FileInputStream(file);
//            XWPFDocument doc = new XWPFDocument(input_document);
//            //72 units=1 inch
//            pdfWriter.setInitialLeading(20);
//            //get all paragraphs from word docx
//            List<XWPFParagraph> plist = doc.getParagraphs();
//            //open pdf document for writing
//            pdfWriter.open();
//            pdfDocument.open();
//            for (int i = 0; i < plist.size(); i++) {
//                //read through the list of paragraphs
//                XWPFParagraph pa = plist.get(i);
//                //get all run objects from each paragraph
//                List<XWPFRun> runs = pa.getRuns();
//                //read through the run objects
//                for (int j = 0; j < runs.size(); j++) {
//                    XWPFRun run = runs.get(j);
//                    //get pictures from the run and add them to the pdf document
//                    List<XWPFPicture> piclist = run.getEmbeddedPictures();
//                    //traverse through the list and write each image to a file
//                    Iterator<XWPFPicture> iterator = piclist.iterator();
//                    while (iterator.hasNext()) {
//                        XWPFPicture pic = iterator.next();
//                        XWPFPictureData picdata = pic.getPictureData();
//                        byte[] bytepic = picdata.getData();
//                        Image imag = Image.getInstance(bytepic);
//                        pdfDocument.add(imag);
//                    }
//                    // 中文字体的解决 Font_Songti为字体的配置文件
//                    BaseFont bf = BaseFont.createFont(fileProperties.getPropertiesByKey("Font_Songti"), BaseFont.IDENTITY_H, BaseFont.NOT_EMBEDDED);
//                    Font font = new Font(bf, 15.0f, Font.NORMAL, BaseColor.BLACK);
//                    //construct unicode string
//                    String text = run.getText(-1);
//                    byte[] bs;
//                    if (text != null) {
//                        bs = text.getBytes();
//                        String str = new String(bs);
//                        //add string to the pdf document
//                        Chunk chObj1 = new Chunk(str, font);
//                        pdfDocument.add(chObj1);
//                    }
//
//                }
//                //output new line
//                pdfDocument.add(new Chunk(Chunk.NEWLINE));
//            }
//            //close pdf document
//            pdfDocument.close();
//            pdfWriter.close();
//            log.info(file.getAbsolutePath() + "Powerpoint file converted to PDF successfully");
//            return toFile;
//        } catch (Exception e) {
//            log.info(file.getAbsolutePath() + "--->" + e.getMessage());
//            return null;
//        }
//
//    }
//
//
//     for(int i = 0; i < slide.length; i++) {
//        for (XSLFShape shape : slide[i].getShapes()) {
//            if (shape instanceof XSLFTextShape) {
//                XSLFTextShape txtshape = (XSLFTextShape) shape;
//                for (XSLFTextParagraph textPara : txtshape.getTextParagraphs()) {
//                    List<XSLFTextRun> textRunList = textPara.getTextRuns();
//                    for (XSLFTextRun textRun : textRunList) {
//                        textRun.setFontFamily("宋体");
//                    }
//                }
//            }
//        }
//
//
//
//    }
