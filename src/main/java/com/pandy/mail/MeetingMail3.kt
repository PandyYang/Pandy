package com.pandy.mail

import com.sun.mail.util.MailSSLSocketFactory
import java.text.SimpleDateFormat
import java.util.*
import javax.activation.DataHandler
import javax.mail.*
import javax.mail.internet.InternetAddress
import javax.mail.internet.MimeBodyPart
import javax.mail.internet.MimeMessage
import javax.mail.internet.MimeMultipart
import javax.mail.util.ByteArrayDataSource

/** 邮件内容*/
data class MeetingMail(
    var from: String? = null,
    var to: List<String>? = null,
    var subject: String? = null,
    var startTime: Date? = null,
    var endTime: Date? = null,
    var method: String? = null,
    var summary: String? = null,
    var text: String? = "会议邀请", //为null 会NullPointerException
    var location: String? = null,
    var vcalendarUID: String? = null
)

val mm = MeetingMail(
    from = "123@123.com",
    to = listOf("123@outlook.com"),
    subject = "测试主题",
    startTime = Date(),
    endTime = Date(),
    method = "REQUEST",
    summary = "测试概要",
    text = "测试正文",
    location = "会议室01",
    vcalendarUID = UUID.randomUUID().toString()
)

fun sendMeetingInvitationEmail(m: MeetingMail) {
    var props: Properties? = null
    var session: Session? = null
    try {
        Thread {
            val startTime = formatUTC(m.startTime!!)
            val endTime = formatUTC(m.endTime!!)

            props = Properties()
            props!!["com.pandy.mail.smtp.port"] = "587"
            props!!["com.pandy.mail.smtp.host"] = "com.pandy.mail.360.net"
            props!!["com.pandy.mail.transport.protocol"] = "smtp"
            props!!["com.pandy.mail.smtp.auth"] = "true"
            props!!["com.pandy.mail.smtp.starttls.enable"] = "true"
            props!!["com.pandy.mail.debug"] = "true"
            val sf = MailSSLSocketFactory()
            sf.isTrustAllHosts = true
            val authenticator: Authenticator = object : Authenticator() {
                override fun getPasswordAuthentication(): PasswordAuthentication {
                    return PasswordAuthentication("123", "123")
                }
            }
            session = Session.getInstance(props, authenticator)
            val message = MimeMessage(session)
            message.setFrom(InternetAddress("123@123.com"))
            //接收者
            m.to?.forEach {
                message.addRecipient(Message.RecipientType.TO, InternetAddress(it))
            }
            //标题
            message.subject = m.subject
            val buffer = StringBuffer()
            buffer.append(
                """
                        BEGIN:VCALENDAR
                        PRODID:-//Microsoft Corporation//Outlook 9.0 MIMEDIR//EN
                        VERSION:2.0
                        METHOD:${m.method}
                        BEGIN:VEVENT
                        DTSTART:$startTime
                        DTEND:$endTime
                        LOCATION:${m.location}
                        UID:${m.vcalendarUID}
                        CATEGORIES:
                        SUMMARY:${m.summary}
                        PRIORITY:5
                        CLASS:PUBLIC
                        BEGIN:VALARM
                        TRIGGER:-PT10M
                        ACTION:DISPLAY
                        DESCRIPTION:Reminder
                        END:VALARM
                        END:VEVENT
                        END:VCALENDAR
                        """.trimIndent()
            )
            val messageBodyPart: BodyPart = MimeBodyPart()
            messageBodyPart.dataHandler = DataHandler(
                ByteArrayDataSource(
                    buffer.toString(),
                    "text/calendar;method=REQUEST;charset=\"UTF-8\""
                )
            )
            val multipart = MimeMultipart()
            val mimeBodyPart = MimeBodyPart()
            mimeBodyPart.setText(m.text)
            multipart.addBodyPart(mimeBodyPart)
            multipart.addBodyPart(messageBodyPart)
            message.setContent(multipart)
            message.sentDate = Date()
            message.saveChanges()
            Transport.send(message)
        }.start()
    } catch (me: Exception) {
        throw Exception("邮件发送失败！")
    }

}

private fun formatUTC(date: Date): String {
    val dateFormat = SimpleDateFormat("yyyyMMdd'T'HHmmss")
    dateFormat.timeZone = TimeZone.getTimeZone("UTC")
    return dateFormat.format(date)
}

fun main() {
    sendMeetingInvitationEmail(mm)
}
