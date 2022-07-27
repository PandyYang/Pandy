package com.pandy.tool.excel;

import java.io.*;
import java.util.ArrayList;

public class WriteBackData {
    private int rowNum;
    private int  cellNum;
    private String content;

    public WriteBackData(int rowNum, int cellNum, String content) {
        this.rowNum = rowNum;
        this.cellNum = cellNum;
        this.content = content;
    }

    public int getRowNum() {
        return rowNum;
    }

    public void setRowNum(int rowNum) {
        this.rowNum = rowNum;
    }

    public int getCellNum() {
        return cellNum;
    }

    public void setCellNum(int cellNum) {
        this.cellNum = cellNum;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    @Override
    public String toString() {
        return "WriteBackData{" +
                "rowNum=" + rowNum +
                ", cellNum=" + cellNum +
                ", content='" + content + '\'' +
                '}';
    }

    public static void main(String[] args) throws IOException {
        WriteBackData writeBackData1 = new WriteBackData(1, 2, "Pass");
        WriteBackData writeBackData2 = new WriteBackData(2, 2, "Fail");
        WriteBackData writeBackData3 = new WriteBackData(3, 2, "Pass");
        ArrayList<WriteBackData> arrayList = new ArrayList<>();
        arrayList.add(writeBackData1);
        arrayList.add(writeBackData2);
        arrayList.add(writeBackData3);

        User user = new User();
        user.setId(5);
        user.setName("qwer");
        user.setPassword("zxcv");
        User user3 = new User();
        user3.setId(6);
        user3.setName("qwerwww");
        WriteExcel.writeToExcel("C:\\Users\\Administrator\\Desktop\\123.xlsx", "Sheet1", user);
    }
}
