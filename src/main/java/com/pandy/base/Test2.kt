package com.pandy.base

fun main() {
    val res = " \"12\"  \"3\""
    println(res)
    val replace = res.replace("\"", "").trim().replace("\\s+".toRegex(), ",").split(",")
    val replace2 = res.replace("\"", "").trim().split(" ")
    val replace3 = res.replace("\"", "").trim().split(" ").size > 1
    val list = arrayOf(" ","1")
    val contains = list.contains("\t")
    println(contains)
    println(replace)
    println(replace2)
    print(replace3)

}
