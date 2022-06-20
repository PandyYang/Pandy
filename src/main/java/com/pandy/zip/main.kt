//package com.pandy.zip
//
//
//import java.io.File
//import java.io.FileInputStream
//import java.io.FileOutputStream
//import java.util.zip.ZipEntry
//import java.util.zip.ZipOutputStream
//
//fun main() {
////    val file = File("C:\\Users\\123\\Projects\\base\\src\\main\\resources\\test\\text.txt")
////    val fileInputStream = FileInputStream(file)
////    val readBytes = fileInputStream.readBytes()
////
//////    val zos = ZipOutputStream(FileOutputStream(File("C:\\Users\\123\\Downloads\\test\\zipTest.zip"),
//////        ),charset("GBK"))
////
////    val zos = ZipOutputStream(FileOutputStream(File("C:\\Users\\123\\Downloads\\test\\zipTest.zip"),
////        ))
////
////    zos.putNextEntry(ZipEntry("测试解/"))
////    zos.closeEntry()
////    zos.putNextEntry(ZipEntry("测试解/二级目录/"))
////    zos.closeEntry()
////    zos.putNextEntry(ZipEntry("测试解/vc.txt"))
////    zos.write(readBytes)
////    zos.closeEntry()
////    zos.putNextEntry(ZipEntry("测试解/xxx.txt"))
////    zos.write(readBytes)
////    zos.closeEntry()
////    zos.putNextEntry(ZipEntry("测试解/二级目录/总结-test-测试解陈华平可见.txt"))
////    zos.write(readBytes)
////    zos.closeEntry()
////
////    zos.close()
////    println("finish")
//
//
//    val file = File("C:\\Users\\123\\Projects\\base\\src\\main\\resources\\test\\text.txt")
//    val fileInputStream = FileInputStream(file)
//    val readBytes = fileInputStream.readBytes()
//
////    val zos = ZipOutputStream(FileOutputStream(File("C:\\Users\\123\\Downloads\\test\\zipTest.zip"),
////        ),charset("GBK"))
//
//    val zos = ZipOutputStream(
//        FileOutputStream(
//            File("C:\\Users\\123\\Downloads\\test\\zipTest.zip"),
//        )
////        ,charset("GBK")
//    )
////    zos.putNextEntry(ZipEntry("测试解压缩/"))
//    zos.putNextEntry(ZipEntry("asdgsdfg/"))
//
//
////
////    zos.putNextEntry(ZipEntry("测试解/vc.txt"))
////    zos.write(readBytes)
////    zos.putNextEntry(ZipEntry("测试解/xxx.txt"))
////    zos.write(readBytes)
////    zos.putNextEntry(ZipEntry("测试解/测试/xxx.txt"))
////    zos.write(readBytes)
//
//    zos.close()
//    println("finish")
//}
