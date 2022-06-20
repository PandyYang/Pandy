//package com.pandy.common.readfile
//
//import com.pandy.time.DateFormat
//import java.io.*
//import java.lang.Exception
//import java.util.*
//import java.util.concurrent.CopyOnWriteArrayList
//import java.util.concurrent.LinkedBlockingQueue
//import java.util.concurrent.ThreadPoolExecutor
//import java.util.concurrent.TimeUnit
//import java.util.zip.GZIPInputStream
//import kotlin.collections.ArrayList
//import kotlin.collections.HashMap
//
///**
// * @date 24/1/2022
// * @author Pandy
// * 读取cdn日志文件进行数据分析
// */
//fun main() {
//
////    val worker = ThreadPoolExecutor(8, 8, 0L, TimeUnit.MILLISECONDS, LinkedBlockingQueue())
//
//    try {
//        val files = ArrayList<File>()
//        getFiles("/Users/pandy/Documents/cdn日志分析/日志", files)
//
//        // 对每个文件进行频率访问统计
//        files.parallelStream().forEach {
//            val timelist = ArrayList<String>()
////            worker.execute {
//                println("正在处理文件 " + it.name)
//                val `in` = GZIPInputStream(FileInputStream(it))
//                val sc = Scanner(`in`)
//                while (sc.hasNextLine()) {
//                    try {
//                        val data = sc.nextLine().toString()
//                        if (!data.contains("skylar6")) {
//                            val dateFormat = DateFormat()
//                            val time= dateFormat.stringToDate(data.split(" ")[0])
//                            timelist.add(time)
//                        }
//                    } catch (e: Exception) {
//                        e.printStackTrace()
//                    }
//                }
//                writeBySec(it.name, timelist)
//                writeByMin(it.name, timelist)
//                writeByHour(it.name, timelist)
////            }
//        }
//
//    } catch (e: IOException) {
//        e.printStackTrace()
//    }
//}
//
//fun writeByMin(filename: String, timelist: List<String>) {
//
////    val file = "/Users/pandy/Documents/cdn日志分析/频率分析/${filename.split("-")[0]}"
////    File(file).mkdir()
//
////    val fileWriter = BufferedWriter(FileWriter("/Users/pandy/Documents/cdn日志分析/频率分析/${filename.split("-")[0]}/${filename}-min.txt", true))
//    val fileWriter = BufferedWriter(FileWriter("/Users/pandy/Documents/cdn日志分析/频率分析1.txt", true))
//    val times = timelist.groupBy{ time ->
////                2021-12-31 00:03:55
//        time.substring(0, 16)
//    }
//
//    for (time in times.entries.parallelStream().sorted{o1, o2 -> o2.value.size - o1.value.size}) {
//        fileWriter.write("${time.key} ${time.value.size}\n\r")
//        fileWriter.flush()
//    }
//    fileWriter.close()
//}
//
//fun writeBySec(filename: String, timelist: List<String>) {
////    val file = "/Users/pandy/Documents/cdn日志分析/频率分析/${filename.split("-")[0]}"
////    File(file).mkdir()
//
////    val fileWriter = BufferedWriter(FileWriter("/Users/pandy/Documents/cdn日志分析/频率分析/${filename.split("-")[0]}/${filename}-sec.txt", true))
//    val fileWriter = BufferedWriter(FileWriter("/Users/pandy/Documents/cdn日志分析/频率分析1.txt", true))
//    val times = timelist.groupBy { it }
//
//    for (time in times.entries.parallelStream().sorted{o1, o2 -> o2.value.size - o1.value.size}) {
//        fileWriter.write("${time.key} ${time.value.size}\n\r")
//        fileWriter.flush()
//    }
//    fileWriter.close()
//}
//
//fun writeByHour(filename: String, timelist: List<String>) {
////    val file = "/Users/pandy/Documents/cdn日志分析/频率分析/${filename.split("-")[0]}"
////    File(file).mkdir()
//
////    val fileWriter = BufferedWriter(FileWriter("/Users/pandy/Documents/cdn日志分析/频率分析/${filename.split("-")[0]}/${filename}-hour.txt", true))
//    val fileWriter = BufferedWriter(FileWriter("/Users/pandy/Documents/cdn日志分析/频率分析1.txt", true))
//    val times = timelist.groupBy{ it.substring(0, 13) }
//
//    for (time in times.entries.parallelStream().sorted{o1, o2 -> o2.value.size - o1.value.size}) {
//        fileWriter.write("${time.key} ${time.value.size}\n\r")
//        fileWriter.flush()
//    }
//    fileWriter.close()
//}
