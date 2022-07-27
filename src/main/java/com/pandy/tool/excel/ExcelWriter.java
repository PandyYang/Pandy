//package com.pandy.java.ForTest;
//
//import org.apache.poi.ss.usermodel.Cell;
//import org.apache.poi.ss.usermodel.Row;
//import org.apache.poi.ss.usermodel.Sheet;
//import org.apache.poi.ss.usermodel.Workbook;
//import org.apache.poi.xssf.streaming.SXSSFWorkbook;
//
//import java.util.Iterator;
//import java.util.List;
//
//public class ExcelWriter {
//    public static Workbook exportData(List<WriteBackData> dataList){
//        // 生成xlsx的Excel
//        Workbook workbook = new SXSSFWorkbook();
//
//        // 如需生成xls的Excel，请使用下面的工作簿对象，注意后续输出时文件后缀名也需更改为xls
//        //Workbook workbook = new HSSFWorkbook();
//        Sheet sheet = buildDataSheet(workbook);
//        //构建每行的数据内容
//        int rowNum = 1;
//        for (Iterator<WriteBackData> it = dataList.iterator(); it.hasNext(); ) {
//            WriteBackData data = it.next();
//            if (data == null) {
//                continue;
//            }
//            Row row = sheet.createRow(rowNum++);
//            convertDataToRow(data, row);
//        }
//        return workbook;
//    }
//
//    private static void convertDataToRow(WriteBackData data, Row row){
//        int cellNum = 0;
//        Cell cell;
//        cell = row.createCell(cellNum++);
//        cell.setCellValue(null == data.getContent() ? "" : data.getContent());
//    }
//
//}
