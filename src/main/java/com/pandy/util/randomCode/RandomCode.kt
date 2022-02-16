package com.pandy.util.randomCode

import java.util.*

/**
 * @date 16/2/2022
 * @author Pandy
 */
fun main() {
    println(randomCode())
}

private fun randomCode(): String {
    val str = StringBuilder()
    val random = Random()
    for (i in 0 until 6) {
        str.append(random.nextInt(10))
    }
    return str.toString()
}
