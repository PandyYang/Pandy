package com.pandy.zip;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

public class TestCompressFolder {
    public static void main(String[] args) {
        exportFriends("C:\\Users\\123\\Downloads\\20210122_1728");
    }

    public static void exportFriends(String pathToFile) {
        String source = pathToFile + ".zip";
        try {
            String sourceDir = "C:\\Users\\123\\Downloads\\20210122_1728";
            String zipFile = source;

            try {
                FileOutputStream fout = new FileOutputStream(zipFile);
                ZipOutputStream zout = new ZipOutputStream(fout);

                File fileSource = new File(sourceDir);

                addDirectory(zout, sourceDir, fileSource);

                zout.close();

                System.out.println("Zip file has been created!");
            } catch (Exception e) {
                e.printStackTrace();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static String getRelativePath(String sourceDir, File file) {
        // Trim off the start of source dir path...
        String path = file.getPath().substring(sourceDir.length());
        if (path.startsWith(File.separator)) {
            path = path.substring(1);
        }
        return path;
    }

    private static void addDirectory(ZipOutputStream zout, String sourceDir, File fileSource) throws IOException {
        if (fileSource.isDirectory()) {
            // Add the directory to the zip entry...
            String path = getRelativePath(sourceDir, fileSource);
            if (path.trim().length() > 0) {
                ZipEntry ze = new ZipEntry(getRelativePath(sourceDir, fileSource));
                zout.putNextEntry(ze);
                zout.closeEntry();
            }

            File[] files = fileSource.listFiles();
            System.out.println("Adding directory " + fileSource.getName());
            for (int i = 0; i < files.length; i++) {
                if (files[i].isDirectory()) {
                    addDirectory(zout, sourceDir, files[i]);
                } else {

                    System.out.println("Adding file " + files[i].getName());

                    //create byte buffer
                    byte[] buffer = new byte[1024];

                    //create object of FileInputStream
                    FileInputStream fin = new FileInputStream(files[i]);
                    zout.putNextEntry(new ZipEntry(getRelativePath(sourceDir, files[i])));

                    int length;

                    while ((length = fin.read(buffer)) > 0) {
                        zout.write(buffer, 0, length);
                    }
                    zout.closeEntry();
                    //close the InputStream
                    fin.close();
                }
            }
        }
    }
}
