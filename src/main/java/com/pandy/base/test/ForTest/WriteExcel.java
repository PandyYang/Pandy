package com.pandy.base.test.ForTest;

import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFAnchor;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.*;
import java.lang.reflect.Method;

public class WriteExcel {
    public static void writeToExcel(String fileDir,String sheetName, Object object){
        //创建workbook
        File file = new File(fileDir);
        XSSFWorkbook workbook = null;
        try {
            workbook = new XSSFWorkbook(new FileInputStream(file));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        //流
        FileOutputStream out = null;
        XSSFSheet sheet = workbook.getSheet(sheetName);
        // 获取表格的总行数
        int rowCount = sheet.getLastRowNum() + 1; // 需要加一
        // 获取表头的列数
        int columnCount = sheet.getRow(0).getLastCellNum();
        try {
            Row row = sheet.createRow(rowCount);     //最新要添加的一行
            //通过反射获得object的字段,对应表头插入
            // 获取该对象的class对象
            Class class_ = object.getClass();
            // 获得表头行对象
            XSSFRow titleRow = sheet.getRow(0);
            if(titleRow!=null){
                for (int columnIndex = 0; columnIndex < columnCount; columnIndex++) {  //遍历表头
                    String title = titleRow.getCell(columnIndex).toString().trim().toString().trim();
                    String UTitle = Character.toUpperCase(title.charAt(0))+ title.substring(1, title.length()); // 使其首字母大写;
                    String methodName  = "get"+UTitle;
                    Method method = class_.getDeclaredMethod(methodName); // 设置要执行的方法
                    String data = method.invoke(object).toString(); // 执行该get方法,即要插入的数据
                    Cell cell = row.createCell(columnIndex);
                    cell.setCellValue(data);
                }
            }

            out = new FileOutputStream(fileDir);
            workbook.write(out);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                out.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
