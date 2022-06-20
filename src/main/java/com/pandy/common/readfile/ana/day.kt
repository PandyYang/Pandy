//package com.pandy.common.readfile.ana
//
//import com.pandy.common.readfile.getFiles
//import com.pandy.common.readfile.readFile
//import java.io.File
//import java.lang.Exception
//import java.util.*
//import java.util.concurrent.CopyOnWriteArrayList
//import kotlin.collections.ArrayList
//import kotlin.math.min
//
///**
// * @date 27/1/2022
// * @author Pandy
// */
//fun main() {
//
//    val hourlist = CopyOnWriteArrayList<List<String>>()
//    val hourlist2 = CopyOnWriteArrayList<List<String>>()
//    val minlist = LinkedList<String>()
//    val seclist = LinkedList<String>()
//
//    val files = ArrayList<File>()
//    getFiles("/Users/pandy/Documents/cdn日志分析/日志分析按天", files)
//    files.forEach{ file ->
//
//
//
//        var hlist = LinkedList<String>()
//        var mlist = LinkedList<String>()
//        var slist = LinkedList<String>()
//
//        val readFile = readFile(file.toString())
//        //
//        val num = 0;
//        readFile.forEach { rf ->
//
//            if (rf != "") {
//                val list = rf!!.split(" ")
//                // 时为2 分为5 秒为8
//                if (list[1].length == 8) {
//                    mlist.add(rf)
//                }
//            }
//        }
//        hourlist.add(mlist)
//    }
//    //println("小时访问量 " + hourlist.toString())
//    // 每天
//    println("百分之百的用户低于---------------------------------")
//    hourlist.forEach {
//        minlist.clear()
//        val res = it.groupBy { it.substring(0, 13) }
//        res.values.forEach { re ->
//            val sss = re.sortedByDescending { s->
//                s.substring(20, s.length).toInt()
//            }
//            minlist.add(sss[0].substring(20, sss[0].length))
//        }
//        println(minlist)
//    }
//
//    println("百分之95的用户低于---------------------------------")
//    hourlist.forEach {
//        minlist.clear()
//        val res = it.groupBy { it.substring(0, 13) }
//        res.values.forEach { re ->
//            val sss = re.sortedByDescending { s->
//                s.substring(20, s.length).toInt()
//            }
//            minlist.add(sss[100].substring(20, sss[100].length))
//        }
//        println(minlist)
//    }
//
//    println("百分之90的用户低于---------------------------------")
//    hourlist.forEach {
//        minlist.clear()
//        val res = it.groupBy { it.substring(0, 13) }
//        res.values.forEach { re ->
//            val sss = re.sortedByDescending { s->
//                s.substring(20, s.length).toInt()
//            }
//            minlist.add(sss[200].substring(20, sss[200].length))
//        }
//        println(minlist)
//    }
//
//    println("百分之85的用户低于---------------------------------")
//    hourlist.forEach {
//        minlist.clear()
//        val res = it.groupBy { it.substring(0, 13) }
//        res.values.forEach { re ->
//            val sss = re.sortedByDescending { s->
//                s.substring(20, s.length).toInt()
//            }
//            minlist.add(sss[300].substring(20, sss[300].length))
//        }
//        println(minlist)
//    }
//
//    println("百分之80的用户低于---------------------------------")
//    hourlist.forEach {
//        minlist.clear()
//        val res = it.groupBy { it.substring(0, 13) }
//        res.values.forEach { re ->
//            val sss = re.sortedByDescending { s->
//                s.substring(20, s.length).toInt()
//            }
//            minlist.add(sss[400].substring(20, sss[400].length))
//        }
//        println(minlist)
//    }
//
////    println(hourlist2.toString())
//
//}
