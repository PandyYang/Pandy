package com.pandy.zip

import net.lingala.zip4j.model.ZipParameters
import java.io.*

fun main() {

    val f = File("/")
    val out: OutputStream = FileOutputStream(f)
    val zop = net.lingala.zip4j.io.ZipOutputStream(out).putNextEntry(f, ZipParameters())
}
