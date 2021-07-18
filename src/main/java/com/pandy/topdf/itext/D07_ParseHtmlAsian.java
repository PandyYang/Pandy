package com.pandy.topdf.itext;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.pdf.PdfWriter;
import com.itextpdf.tool.xml.XMLWorkerHelper;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.charset.StandardCharsets;

public class D07_ParseHtmlAsian {//the document has no page! 因为只能将html转化为pdf


    public static final String HTML = "D:\\IdeaProjects\\com.pandy.base\\src\\main\\resources\\test\\123.docx";
    public static final String DEST = "D:\\IdeaProjects\\com.pandy.base\\src\\main\\resources\\test\\123-itext-word.pdf";

    /**
     * Main method
     */
    public static void main(String[] args) throws IOException, DocumentException {
        File file = new File(DEST);
        file.getParentFile().mkdirs();
        new D07_ParseHtmlAsian().createPdf(DEST);
    }

    /**
     * Creates a PDF with the words "Hello World"
     *
     * @param file
     * @throws IOException
     * @throws DocumentException
     */
    public void createPdf(String file) throws IOException, DocumentException {
        // step 1
        Document document = new Document();
        // step 2
        PdfWriter writer = PdfWriter.getInstance(document, new FileOutputStream(file));
        // step 3
        document.open();
        // step 4
        XMLWorkerHelper.getInstance().parseXHtml(writer, document,
                new FileInputStream(HTML), StandardCharsets.UTF_8);
        // step 5
        document.close();
    }
}
