package com.pandy.test

import java.time.LocalDate
import java.time.ZoneId
import java.time.temporal.ChronoUnit
import java.util.*

/**
 * @date 16/2/2022
 * @author Pandy
 */

fun main() {
    val gapDays = getGapDays(Date(1642377600000), Date(1642475471000))
    println(gapDays)
}

fun getGapDays(startDay: Date, endDay: Date): Long {
    return ChronoUnit.DAYS.between(toLocalDate(startDay), toLocalDate(endDay))
}

fun toLocalDate(date: Date): LocalDate {
    return date.toInstant().atZone(ZoneId.systemDefault()).toLocalDate()
}

