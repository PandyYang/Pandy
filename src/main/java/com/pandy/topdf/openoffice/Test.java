package com.pandy.topdf.openoffice;

public class Test {
    public static void main(String[] args) {
        OpenOfficeUtils.toPdf("D:\\IdeaProjects\\com.pandy.base\\src\\main\\resources\\test\\wpsDoc.wps",
                "D:\\IdeaProjects\\com.pandy.base\\src\\main\\resources\\test\\1111.pdf");
        OpenOfficeUtils.toPdf("D:\\IdeaProjects\\com.pandy.base\\src\\main\\resources\\test\\wpsExcel.et",
                "D:\\IdeaProjects\\com.pandy.base\\src\\main\\resources\\test\\2222.pdf");
        OpenOfficeUtils.toPdf("D:\\IdeaProjects\\com.pandy.base\\src\\main\\resources\\test\\wpsPpt.dps",
                "D:\\IdeaProjects\\com.pandy.base\\src\\main\\resources\\test\\3333.pdf");
    }
}
