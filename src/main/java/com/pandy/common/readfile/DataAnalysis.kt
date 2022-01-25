package com.qianxin.hiner2.utils

import java.io.BufferedReader
import java.io.File
import java.io.FileInputStream
import java.io.InputStreamReader
import java.util.*


/**
 * @date 25/1/2022
 * @author Pandy
 */
fun main() {
    val files = readTxtFileIntoStringArrList("/Users/pandy/Documents/cdn日志分析/分析数据.txt")
    files.filter { it != "" }.forEach { file ->
        val filepath = file?.split(" ")?.get(1)
        val num = file?.split(" ")?.get(4)?.replace(",", "")
        println("$filepath $num")
    }
}


fun readTxtFileIntoStringArrList(filePath: String): List<String?> {
    val list: MutableList<String?> = ArrayList()
    try {
        val encoding = "utf8"
        val file = File(filePath)
        if (file.isFile && file.exists()) { // 判断文件是否存在
            val read = InputStreamReader(FileInputStream(file), encoding) // 考虑到编码格式
            val bufferedReader = BufferedReader(read)
            var lineTxt: String? = null
            while (bufferedReader.readLine().also { lineTxt = it } != null) {
                list.add(lineTxt)
            }
            bufferedReader.close()
            read.close()
        } else {
            println("找不到指定的文件")
        }
    } catch (e: Exception) {
        println("读取文件内容出错")
        e.printStackTrace()
    }
    return list
}
