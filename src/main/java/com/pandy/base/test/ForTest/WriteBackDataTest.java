//package com.pandy.base.test.ForTest;
////        2、创建3个WriteBackData对象 (10分)
////        w1：行号 1，列号 2，内容 Pass
////        w2：行号 2，列号 2，内容 Fail
////        w3：行号 3，列号 2，内容 Pass
////        3、把w1、w2、w3放入ArrayList集合中。(10分)
////        4、通过poi把ArrayList集合中的数据回写到exam.xls（请下载，不需要自己创建）文件中第一个Sheet。(30分)
////        回写规则：按照WriteBackData对象的rowNum （行号）  和cellNum （列号）  回写对应的excel中， content（内容）  是回写的具体内容。
//
//import org.apache.poi.ss.usermodel.Row;
//import org.apache.poi.ss.usermodel.Sheet;
//import org.apache.poi.ss.usermodel.Workbook;
//import org.apache.poi.ss.usermodel.WorkbookFactory;
//
//import java.io.FileInputStream;
//import java.io.FileNotFoundException;
//import java.util.ArrayList;
//import java.util.List;
//
//public class WriteBackDataTest {
//    public static void main(String[] args) throws Exception {
//        WritebackData w1 = new WritebackData(1,1,"pass");
//        WritebackData w2 = new WritebackData(2,2,"Fail");
//        WritebackData w3 = new WritebackData(3,2,"Pass");
//        //把w1、w2、w3放入ArrayList集合中
//        List<WritebackData> list= new ArrayList<>();
//        list.add(w1);
//        list.add(w2);
//        list.add(w3);
////通过poi把ArrayList集合中的数据回写到exam.xls（请下载，不需要自己创建）
//// 文件中第一个Sheet。(30分)
////回写规则：按照WriteBackData对象的rowNum （行号）  和cellNum （列号）
//// 回写对应的excel中，content（内容）  是回写的具体内容。
//        FileInputStream fis = new FileInputStream("src/test/resources/exam.xls");
//        Workbook sheets = WorkbookFactory.create(fis);
//        Sheet sheetAt = sheets.getSheetAt(0);
//        for(int i = 0; i<list.get(i).getRowNum();i++){
//            for(int j = 0;j<list.get(j).getCellNum();j++){
//
//            }
//        }
//    }
//
//}
