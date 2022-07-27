//package com.pandy.common.readfile.ana
//
//import java.io.*
//import java.util.ArrayList
//
///**
// * @date 26/1/2022
// * @author Pandy
// */
//fun main() {
//    val list: MutableList<String?> = ArrayList()
//    val set = HashSet<String>()
//    val fileWriter = BufferedWriter(FileWriter("/Users/pandy/Documents/cdn日志分析/频率分析(去重).txt", true))
//    var num = 0;
//    try {
//        val encoding = "utf8"
//        val file = File("/Users/pandy/Documents/cdn日志分析/频率分析.txt")
//        if (file.isFile && file.exists()) { // 判断文件是否存在
//            val read = InputStreamReader(FileInputStream(file), encoding) // 考虑到编码格式
//            val bufferedReader = BufferedReader(read)
//            var lineTxt = ""
//
//
//            while (bufferedReader.readLine()?.also { lineTxt = it } != null) {
//                if (set.add(lineTxt)) {
//                    fileWriter.write("$lineTxt\n\r")
//                    fileWriter.flush()
//                }
//            }
//            bufferedReader.close()
//            read.close()
//        } else {
//            println("找不到指定的文件")
//        }
//    } catch (e: Exception) {
//        println("读取文件内容出错")
//        e.printStackTrace()
//    }
//    fileWriter.close()
//}
