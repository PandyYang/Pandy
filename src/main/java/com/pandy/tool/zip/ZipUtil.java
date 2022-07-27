package com.pandy.tool.zip;

import org.apache.commons.lang3.StringUtils;

import java.io.*;
import java.nio.charset.Charset;
import java.util.List;
import java.util.zip.CRC32;
import java.util.zip.Deflater;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

/**
 * <p>文件压缩类</p>
 *
 * @author chen eryong
 */
public class ZipUtil {

    public ZipUtil() {
    }

    /**
     * 方法名：getFileBytes<br>
     * 描述：获取文件的bytes<br>
     * 创建时间：2016-12-14 下午2:23:33<br>
     *
     * @param file
     * @return
     * @throws FileNotFoundException
     * @throws IOException<>
     */
    public static byte[] getFileBytes(File file) throws FileNotFoundException,
            IOException {
        byte[] buffer;
        FileInputStream fis = new FileInputStream(file);
        ByteArrayOutputStream bos = new ByteArrayOutputStream(1000);
        byte[] b = new byte[1000];
        int n;
        while ((n = fis.read(b)) != -1) {
            bos.write(b, 0, n);
        }
        fis.close();
        bos.close();
        buffer = bos.toByteArray();
        return buffer;
    }

    /**
     * <p>功能：文件压缩压缩包</p>
     *
     * @param zipFileName -- 压缩文件名
     * @param sourceFile  -- 待压缩文件
     */
    public void zip(String zipFileName, File sourceFile) throws Exception {
        File zipFile = new File(zipFileName);
        if (!zipFile.exists()) {
            zipFile.createNewFile();
        }

        Charset charset = Charset.forName("GBK");
        ZipOutputStream out = new ZipOutputStream(new FileOutputStream(zipFile), charset);
        out.setLevel(Deflater.NO_COMPRESSION);
        out.setMethod(ZipOutputStream.STORED);
        BufferedOutputStream bos = new BufferedOutputStream(out);
        zip(out, sourceFile, "", bos);
        bos.close();
        out.close(); // 输出流关闭
    }

    /**
     * <p>功能：将待压缩文件夹中的各文件写入压缩包</p>
     *
     * @param out        -- 压缩文件名
     * @param sourceFile -- 待压缩文件
     * @param base       -- 压缩点
     * @param bos        -- 待压缩文件
     */
    private void zip(ZipOutputStream out, File sourceFile, String base, BufferedOutputStream bos) throws Exception {
        if (sourceFile.isDirectory()) {
            File[] fl = sourceFile.listFiles();

            if (fl != null) {
                /*递归遍历子文件夹*/
                for (int i = 0; i < fl.length; i++) {
                    if (StringUtils.isNotEmpty(base)) {
                        zip(out, fl[i], base + "/" + fl[i].getName(), bos);
                    } else {
                        zip(out, fl[i], fl[i].getName(), bos);
                    }
                }
            }

        } else {

            ZipEntry zipEntry = new ZipEntry(base);

            /** ZipEntry.STORED */
            zipEntry.setMethod(ZipEntry.STORED);
            zipEntry.setCompressedSize(sourceFile.length());
            zipEntry.setSize(sourceFile.length());
            CRC32 crc = new CRC32();
            crc.update(getFileBytes(sourceFile));
            zipEntry.setCrc(crc.getValue());
            out.putNextEntry(zipEntry);
            // 创建zip压缩进入点base
            FileInputStream in = new FileInputStream(sourceFile);
            BufferedInputStream bi = new BufferedInputStream(in);
            int b;
            while ((b = bi.read()) != -1) {
                bos.write(b); // 将字节流写入当前zip目录
            }
            bos.flush();
            bi.close();
            in.close(); // 输入流关闭
        }
    }

    /**
     * <p>功能：排除部分文件的压缩</p>
     *
     * @param zipFileName  -- 压缩文件名
     * @param sourceFile   -- 待压缩文件
     * @param excludeFiles -- 排除文件名列表（精确匹配）
     */
    public void zipExcluds(String zipFileName, File sourceFile, List<String> excludeFiles) throws Exception {
        File zipFile = new File(zipFileName);
        if (!zipFile.exists()) {
            zipFile.createNewFile();
        }

        Charset charset = Charset.forName("GBK");
        ZipOutputStream out = new ZipOutputStream(new FileOutputStream(zipFile), charset);
        out.setLevel(Deflater.NO_COMPRESSION);
        out.setMethod(ZipOutputStream.STORED);
        BufferedOutputStream bos = new BufferedOutputStream(out);
        zip(out, sourceFile, "", bos, excludeFiles);
        bos.close();
        out.close(); // 输出流关闭
    }

    /**
     * <p>功能：将待压缩文件夹中的各文件写入压缩包,支持排除部分文件</p>
     *
     * @param out          -- 压缩文件流
     * @param sourceFile   -- 待压缩文件
     * @param base         -- 压缩点
     * @param bos          -- 缓存流
     * @param excludeFiles -- 压缩排除文件名称列表
     */
    private void zip(ZipOutputStream out, File sourceFile, String base, BufferedOutputStream bos,
                     List<String> excludeFiles) throws Exception {
        if (sourceFile.isDirectory()) {
            File[] fl = sourceFile.listFiles();

            if (fl != null) {
                /*递归遍历子文件夹*/
                for (int i = 0; i < fl.length; i++) {
                    if (StringUtils.isNotEmpty(base)) {
                        zip(out, fl[i], base + "/" + fl[i].getName(), bos, excludeFiles);
                    } else {
                        zip(out, fl[i], fl[i].getName(), bos, excludeFiles);
                    }
                }
            }

        } else {
            String fileName = sourceFile.getName();
            if (excludeFiles != null && excludeFiles.size() > 0) {
                if (excludeFiles.contains(fileName)) {
                    return;
                }
            }

            ZipEntry zipEntry = new ZipEntry(base);

            /** ZipEntry.STORED */
            zipEntry.setMethod(ZipEntry.STORED);
            zipEntry.setCompressedSize(sourceFile.length());
            zipEntry.setSize(sourceFile.length());
            CRC32 crc = new CRC32();
            crc.update(getFileBytes(sourceFile));
            zipEntry.setCrc(crc.getValue());
            out.putNextEntry(zipEntry);
            // 创建zip压缩进入点base
            FileInputStream in = new FileInputStream(sourceFile);
            BufferedInputStream bi = new BufferedInputStream(in);
            int b;
            while ((b = bi.read()) != -1) {
                bos.write(b); // 将字节流写入当前zip目录
            }
            bos.flush();
            bi.close();
            in.close(); // 输入流关闭
        }
    }

}
