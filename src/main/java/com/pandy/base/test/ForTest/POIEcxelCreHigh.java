package com.pandy.base.test.ForTest;

import org.apache.commons.io.FileUtils;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileOutputStream;
import java.util.ArrayList;

public class POIEcxelCreHigh {
    /**
     * POI 创建高版本Excel文件
     * @author yangtingting
     * @date 2019/07/29
     */
    public static void main(String[] args) throws Exception {
        //创建Excel文件薄
        XSSFWorkbook workbook=new XSSFWorkbook();
        //创建工作表sheeet
        Sheet sheet=workbook.createSheet();

        WriteBackData writeBackData1 = new WriteBackData(1, 2, "Pass");
        WriteBackData writeBackData2 = new WriteBackData(2, 2, "Fail");
        WriteBackData writeBackData3 = new WriteBackData(3, 2, "Pass");
        ArrayList<WriteBackData> arrayList = new ArrayList<>();
        arrayList.add(writeBackData1);
        arrayList.add(writeBackData2);
        arrayList.add(writeBackData3);

        //追加数据
        for (int i=0;i<arrayList.size();i++){
            Row nextrow=sheet.createRow(i);
            Cell cell2=nextrow.createCell(1);
            cell2.setCellValue(arrayList.get(i).getContent());
        }
        //创建一个文件
        File file=new File("C:\\Users\\Administrator\\Desktop\\123.xlsx");
        file.createNewFile();
        FileOutputStream stream= FileUtils.openOutputStream(file);
        workbook.write(stream);
        stream.close();

    }
}
