package com.pandy.base


internal fun test() {
    println("123")
}

fun main() {
    val list = listOf<Int>(1, 2, 3)
    println(list.elementAt(1))
    println(list.elementAtOrElse(6) { 2 })
    println(list.find { it == 2 })
    println(list.first())
    list.iterator().forEach { println(it) }
    println(list.random())
    val name = "123"
    val value = 123
    val addr = null
    println(addr ?: "")
}
