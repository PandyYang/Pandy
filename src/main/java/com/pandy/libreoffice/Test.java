//package com.pandy.libreoffice;
//
//import java.io.*;
//
//import org.jodconverter.JodConverter;
//import org.jodconverter.document.DocumentFormat;
//import org.jodconverter.office.LocalOfficeManager;
//import org.jodconverter.office.LocalOfficeUtils;
//import org.jodconverter.office.OfficeException;
//import org.jodconverter.office.OfficeManager;
//
//public class Test {
//
//    public static void main(String[] args) throws OfficeException, InterruptedException, FileNotFoundException {
////        RemoteOfficeManager officeManager = RemoteOfficeManager.make("http://localhost:2002").builder().build();
//
//        final OfficeManager officeManager = LocalOfficeManager.builder()
//                .install()
//                .officeHome("C:\\Program Files\\LibreOffice")
//                .build();
//
//        //just can use blow this to replace above
//        final LocalOfficeManager officeManager1 = LocalOfficeManager.install();
//
//
//        File inputFile = new File("D:\\yyy.txt");
//        File outputFile = new File("D:\\yyy.pdf");
//        InputStream inputStream = new FileInputStream(inputFile);
//        OutputStream outputStream = new FileOutputStream(outputFile);
//        JodConverter
//                .convert(inputStream).to(outputStream)
//                .execute();
//        try {
//            // Start an office process and connect to the started instance (on port 2002).
//            officeManager.start();
//            // Convert
//            JodConverter
//                    .convert(inputFile)
//                    .to(outputFile)
//                    .execute();
//        } finally {
//            // Stop the office process
////            officeManager.stop();
//            LocalOfficeUtils.stopQuietly(officeManager);
////            OfficeUtils.stopQuietly(officeManager);
//        }
//    }
//}
