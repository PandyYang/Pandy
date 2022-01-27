package com.pandy.common.readfile

import java.io.*
import java.lang.Exception
import java.util.*
import java.util.concurrent.ConcurrentHashMap
import java.util.zip.GZIPInputStream
import kotlin.collections.ArrayList

/**
 * @date 24/1/2022
 * @author Pandy
 * 读取cdn日志文件进行数据分析
 */
fun main() {

    try {

        val map = ConcurrentHashMap<String, Int>()
        val list = ArrayList<File>()
        getFiles("/Users/pandy/Documents/cdn日志分析", list)

        list.parallelStream().forEach {
            println("正在处理文件 " + it.name)
            val `in` = GZIPInputStream(FileInputStream(it))
            val sc = Scanner(`in`)
            while (sc.hasNextLine()) {
                try {
                    var key = sc.nextLine().toString().split(" ")[3]
                    if (key.contains("?")) {
                        key = key.split("?")[0]
                    }
                    if (map.containsKey(key)) {
                        map[key] = map[key]!! + 1
                    } else {
                        map[key] = 1
                    }
                } catch (e: Exception) {
                    e.printStackTrace()
                }
            }
        }
        println("收集到的文件总数为：" + map.size)
        val fileWriter = BufferedWriter(FileWriter("/Users/pandy/Documents/cdn日志分析/分析数据.txt", true))
        for (entry in map.entries.parallelStream().sorted { o1, o2 -> o2.value - o1.value }) {
            println("访问路径为" + entry.key + " " + "访问次数为" + entry.value)
            fileWriter.write("访问路径为: ${entry.key} 访问次数为: + ${entry.value},\n\r")
            fileWriter.flush()
        }
        fileWriter.close()
    } catch (e: IOException) {
        e.printStackTrace()
    }
}

fun getFiles(path: String, list: ArrayList<File>) {
    val file = File(path)
    if (file.isDirectory) {
        val files = file.listFiles()
        for (f in files!!) {
            if (f.isDirectory) {
                getFiles(f.path, list)
            } else {
                if (!f.name.contains("Store"))
                    list.add(f)
            }
        }
    }
}



