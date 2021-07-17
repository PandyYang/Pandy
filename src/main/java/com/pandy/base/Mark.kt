package com.pandy.base

fun main() {
    val ss = "</em>123</em>.txt"
    val res = ss.replace("(<|</)em>".toRegex(), "")
    println(res)
}
