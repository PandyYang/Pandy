package com.pandy.base

import java.util.*

fun main() {
//
//    val toList = mutableListOf("123@123.com","123@123.com","123@123.com")
//    val s = toList.map{
//        "ATTENDEE;ROLE=REQ-PARTICIPANT;RSVP=TRUE:MAILTO:$it\n"
//    }
//    val ss = StringUtils.strip(s.toString(), "[]").replace(",", "")
//    println(ss)

    val toList = mutableListOf("123@123.com", "123@outlook.com")

    val sb = StringBuffer()
//    val s = toList.map{
//        "ATTENDEE;CUTYPE=INDIVIDUAL;PARTSTAT=NEEDS-ACTION;ROLE=REQ-PARTICIPANT;RSVP=FALSE:mailto:${it}\n"
//    }.forEach {
//        sb.append(it)
//    }

    val xxx =
        toList.joinToString("\n") { "ATTENDEE;CUTYPE=INDIVIDUAL;PARTSTAT=NEEDS-ACTION;ROLE=REQ-PARTICIPANT;RSVP=FALSE:mailto:$it" }

//    ${sb.toString().replace(" ", "\n")}

    val buffer = StringBuffer()
    val str = " BEGIN:VCALENDAR\n" +
            "PRODID:-//Microsoft Corporation//Outlook 9.0 MIMEDIR//EN\n" +
            "VERSION:2.0\n" +
            "METHOD:REQUEST\n" +
            "BEGIN:VEVENT\n" +
            "$xxx\n" +
            "UID:${UUID.randomUUID()}\n" +
            "CATEGORIES:\n" +
            "SUMMARY:\n" +
            "PRIORITY:5\n" +
            "CLASS:PUBLIC\n" +
            "BEGIN:VALARM\n" +
            "TRIGGER:-PT10M\n" +
            "ACTION:DISPLAY\n" +
            "DESCRIPTION:Reminder\n" +
            "END:VALARM\n" +
            "END:VEVENT\n" +
            "END:VCALENDAR"

    println(str)
}
