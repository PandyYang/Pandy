package com.pandy.zip

import java.io.File
import java.io.FileOutputStream
import java.util.zip.ZipEntry
import java.util.zip.ZipOutputStream

fun main() {

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
//    )
//
//    zos.putNextEntry(ZipEntry("哈哈/"))
//    zos.closeEntry()
//    zos.putNextEntry(ZipEntry("哈哈/vc.txt"))
//    zos.write(readBytes)
//    zos.closeEntry()
//    zos.putNextEntry(ZipEntry("哈哈/xxx.txt"))
//    zos.write(readBytes)
//    zos.putNextEntry(ZipEntry("哈哈/厉害/xxx.txt"))
//    zos.write(readBytes)
//    zos.closeEntry()
//
//
//    zos.close()
//    println("finish")


//    val file = File("C:\\Users\\123\\Projects\\base\\src\\main\\resources\\test\\text.txt")
//    val fileInputStream = FileInputStream(file)
//    val readBytes = fileInputStream.readBytes()

//    val zos = ZipOutputStream(FileOutputStream(File("C:\\Users\\123\\Downloads\\test\\zipTest.zip"),
//        ),charset("GBK"))

    val zos = ZipOutputStream(
        FileOutputStream(
            File("C:\\Users\\123\\Downloads\\123.zip")
        ), charset("GBK")
    )

    zos.putNextEntry(ZipEntry("测试解压缩/"))
    zos.closeEntry()
//    zos.putNextEntry(ZipEntry("什么情况/二级目录/"))
//    zos.closeEntry()
//    zos.putNextEntry(ZipEntry("什么情况/vc.txt"))
//    zos.write(readBytes)
//    zos.closeEntry()
//    zos.putNextEntry(ZipEntry("什么情况/xxx.txt"))
//    zos.write(readBytes)
//    zos.closeEntry()
//    zos.putNextEntry(ZipEntry("什么情况/二级目录/总结-test-测试陈华平可见.txt"))
//    zos.write(readBytes)
//    zos.closeEntry()

    zos.close()
    println("finish")

}
