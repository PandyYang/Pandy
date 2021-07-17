package com.pandy.zip;

import com.github.houbb.compress.util.CompressHelper;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;

public class FileTest {
    private static final Logger logger = LoggerFactory.getLogger(FileTest.class);

    @Test
    public void test() {
        getFileName("C:\\Users\\123\\Downloads\\20210122_1728");
    }

    private void getFileName(String filePath) {
        if (null != filePath && "".equals(filePath)) {
            File file = new File(filePath);
            //判断文件或目录是否存在
            if (!file.exists()) {
                logger.info("【" + filePath + " not exists】");
            }
            //获取该文件夹下所有的文件
            File[] fileArray = file.listFiles();
            File fileName = null;
            for (int i = 0; i < fileArray.length; i++) {
                fileName = fileArray[i];
                //判断此文件是否存在
                if (fileName.isDirectory()) {
                    logger.info("【目录：" + fileName.getName() + "】");
                } else {
                    CompressHelper.compress(filePath + fileName.getName());
                    logger.info(fileName.getName());
                }
            }
        }
    }
}
