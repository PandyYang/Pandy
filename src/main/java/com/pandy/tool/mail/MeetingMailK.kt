//package com.pandy.tool.mail
//
//import com.sun.mail.util.MailSSLSocketFactory
//import java.text.DateFormat
//import java.text.ParseException
//import java.text.SimpleDateFormat
//import java.util.*
//import javax.activation.DataHandler
//import javax.mail.*
//import javax.mail.internet.InternetAddress
//import javax.mail.internet.MimeBodyPart
//import javax.mail.internet.MimeMessage
//import javax.mail.internet.MimeMultipart
//import javax.mail.util.ByteArrayDataSource
//
//fun main() {
//    MeetingMailK().sendMeetingInvitationEmail()
//}
//
//data class Person(var name: String, var mail: String)
//
//class MeetingMailK {
//    private val toList = mutableListOf("123@123.com", "123@outlook.com")
//
//    //    val sb = StringBuffer()
////    val s = toList.map{
////        "ATTENDEE;CUTYPE=INDIVIDUAL;PARTSTAT=NEEDS-ACTION;ROLE=REQ-PARTICIPANT;RSVP=FALSE:mailto:$it\n"
////    }.forEach {
////        sb.append(it)
////    }
//    val xxx =
//        toList.joinToString("\n") { "ATTENDEE;CUTYPE=INDIVIDUAL;PARTSTAT=NEEDS-ACTION;ROLE=REQ-PARTICIPANT;RSVP=FALSE:mailto:$it" }
//
//    //private val attendee = StringUtils.strip(s.toString(), "[]").replace(",", "").replace(" ", "")
//    private var props: Properties? = null
//    private var session: Session? = null
//
//    /**
//     * 发送会议邀请
//     * fromEmail: 发送人
//     * toEmail: 接收人
//     * userId: 发件人邮箱账号
//     * password: 发件人邮箱密码 例如QQ开启smtp之后需要使用授权码
//     * subject: 标题
//     * startTime: 会议开始时间
//     * endTime: 会议结束时间
//     * METHOD: 创建会议或者取消会议 REQUEST -> 为创建或者修改 CANCEL ->取消会议
//     * SUMMARY: 会议描述
//     * text: 会议正文
//     * LOCATION: 会议地点
//     * MAILTO: 参会者
//     */
//    fun sendMeetingInvitationEmail() {
//        val addr = null
////        val res  = addr?:""
//        println(addr ?: "")
//        try {
//            props = Properties()
//            //发件人
//            val fromEmail = props!!.getProperty("fromEmail", "123@123.com")
////            val fromEmail2 = props!!.getProperty("fromEmail", "123@123-123.cn")
//            val fromEmail2 = props!!.getProperty("fromEmail", "123@123.com")
////            val fromEmail2 = props!!.getProperty("fromEmail", "123@123.com")
//            //收件人(面试官)
////            val toEmail = props!!.getProperty("toEmail", "123@123.com")
//            val toEmail = props!!.getProperty("toEmail", "123@outlook.com")
//            val toEmail2 = props!!.getProperty("toEmail", "123@123.com")
//            props!!["com.pandy.tool.mail.smtp.port"] = "587"
//            props!!["com.pandy.tool.mail.smtp.host"] = "com.pandy.tool.mail.360.net"
//            //当前smtp host设为可信任 否则抛出javax.com.pandy.tool.mail.MessagingException: Could not                   convert socket to TLS
////            props!!["com.pandy.tool.mail.smtp.ssl.trust"] = "smtp.qq.com"
//            props!!["com.pandy.tool.mail.transport.protocol"] = "smtp"
//            props!!["com.pandy.tool.mail.smtp.auth"] = "true"
//            props!!["com.pandy.tool.mail.smtp.starttls.enable"] = "true"
////            props!!["com.pandy.tool.mail.smtp.tls"] = "true"
//            //开启debug调试，控制台会打印相关信息
//            props!!["com.pandy.tool.mail.debug"] = "true"
//            val sf = MailSSLSocketFactory()
//            sf.isTrustAllHosts = true
////            props!!["com.pandy.tool.mail.smtp.ssl.enable"] = "true"
////            props!!["com.pandy.tool.mail.smtp.ssl.socketFactory"] = sf
//            val authenticator: Authenticator = object : Authenticator() {
//                override fun getPasswordAuthentication(): PasswordAuthentication {
//                    //发件人邮箱账号
//                    val userId = props!!.getProperty("userId", "123")
//                    //发件人邮箱密码(qq、163等邮箱用的是授权码,outlook是密码)
//                    val password = props!!.getProperty("password", "123")
//                    return PasswordAuthentication(userId, password)
//                }
//            }
//            session = Session.getInstance(props, authenticator)
//            val message = MimeMessage(session)
////            message.setFrom(InternetAddress(fromEmail))
//            message.setFrom(InternetAddress(fromEmail2))
////            message.addRecipient(Message.RecipientType.TO, InternetAddress(toEmail))
//            toList.forEach {
//                message.addRecipient(Message.RecipientType.TO, InternetAddress(it))
//            }
//            //标题
//            message.subject = "会议邀请"
//            //面试开始时间
//            val startTime = getUtc("2020-12-03 20:00")
//            //面试结束时间
//            val endTime = getUtc("2020-12-03 20:30")
//            val buffer = StringBuffer()
//
//            val qawe1 = """
//                        BEGIN:VCALENDAR
//                        PRODID:-//Microsoft Corporation//Outlook 9.0 MIMEDIR//EN
//                        VERSION:2.0
//                        METHOD:CANCEL
//                        BEGIN:VEVENT
//                        DTSTART:$startTime
//                        DTEND:$endTime
//                        UID:${8869981}
//                        CATEGORIES:
//                        SUMMARY:
//                        PRIORITY:5
//                        CLASS:PUBLIC
//                        BEGIN:VALARM
//                        TRIGGER:-PT10M
//                        ACTION:DISPLAY
//                        DESCRIPTION:Reminder
//                        END:VALARM
//                        END:VEVENT
//                        END:VCALENDAR
//                        """.trimIndent().replace(" ", "")
//
//            val qawe2 = """
//                        BEGIN:VCALENDAR
//                        PRODID:-//Microsoft Corporation//Outlook 9.0 MIMEDIR//EN
//                        VERSION:2.0
//                        METHOD:REQUEST
//                        BEGIN:VEVENT
//                        $xxx
//                        DTSTART:$startTime
//                        DTEND:$endTime
//                        LOCATION:${addr ?: ""}
//                        UID:${UUID.randomUUID()}
//                        CATEGORIES:
//                        SUMMARY:
//                        PRIORITY:5
//                        CLASS:PUBLIC
//                        BEGIN:VALARM
//                        TRIGGER:-PT10M
//                        ACTION:DISPLAY
//                        DESCRIPTION:Reminder
//                        END:VALARM
//                        END:VEVENT
//                        END:VCALENDAR
//                        """.trimIndent()
//
//            println("========1111111111111======")
//            println(qawe1)
//            println("========2222222222222======")
//            println(qawe2)
//            println("========@@@@@@@@@@@@@======")
//
//
//            val str = " BEGIN:VCALENDAR\n" +
//                    "PRODID:-//Microsoft Corporation//Outlook 9.0 MIMEDIR//EN\n" +
//                    "VERSION:2.0\n" +
//                    "METHOD:CANCEL\n" +
//                    "BEGIN:VEVENT\n" +
//                    "$xxx\n" +
//                    "UID:${UUID.randomUUID()}\n" +
//                    "DTSTART:$startTime\n" +
//                    "DTEND:$endTime\n" +
//                    "LOCATION:${addr ?: ""}\n" +
//                    "CATEGORIES:\n" +
//                    "SUMMARY:\n" +
//                    "PRIORITY:5\n" +
//                    "CLASS:PUBLIC\n" +
//                    "BEGIN:VALARM\n" +
//                    "TRIGGER:-PT10M\n" +
//                    "ACTION:DISPLAY\n" +
//                    "DESCRIPTION:Reminder\n" +
//                    "END:VALARM\n" +
//                    "END:VEVENT\n" +
//                    "END:VCALENDAR"
//
//
//            buffer.append(qawe1)
//            val messageBodyPart: BodyPart = MimeBodyPart()
//            messageBodyPart.dataHandler = DataHandler(
//                ByteArrayDataSource(
//                    buffer.toString(),
//                    "text/calendar;method=REQUEST;charset=\"UTF-8\""
//                )
//            )
//            val multipart = MimeMultipart()
//            val mimeBodyPart = MimeBodyPart()
//            //String emailText = getHtmlContent(sendEmailApi.getTemplateContent(tempValue),tempMap);
//            //文本类型正文
//            mimeBodyPart.setText("")
//            //html类型正文
//            //mimeBodyPart.setContent(emailText,"text/html;charset=UTF-8");
//            //添加正文
//            multipart.addBodyPart(mimeBodyPart)
//            //添加日历
//            multipart.addBodyPart(messageBodyPart)
//            message.setContent(multipart)
//            message.sentDate = Date()
//            message.saveChanges()
//            Transport.send(message)
//        } catch (me: MessagingException) {
//            me.printStackTrace()
//        } catch (ex: Exception) {
//            ex.printStackTrace()
//        }
//    }
//
//    /**
//     * 撤销会议邀请
//     * @throws Exception
//     */
//    fun sendMeetingCancelEmail() {
//        try {
//            props = Properties()
//            //发件人
//            val fromEmail = props!!.getProperty("fromEmail", "390346484@qq.com")
//            //收件人(面试官)
//            val toEmail = props!!.getProperty("toEmail", "123@outlook.com")
//            props!!["com.pandy.tool.mail.smtp.port"] = "465"
//            props!!["com.pandy.tool.mail.smtp.host"] = "smtp.qq.com"
//            //当前smtp host设为可信任 否则抛出javax.com.pandy.tool.mail.MessagingException: Could not                   convert socket to TLS
//            props!!["com.pandy.tool.mail.smtp.ssl.trust"] = "smtp.qq.com"
//            props!!["com.pandy.tool.mail.transport.protocol"] = "smtp"
//            props!!["com.pandy.tool.mail.smtp.auth"] = "true"
//            props!!["com.pandy.tool.mail.smtp.starttls.enable"] = "true"
//            props!!["com.pandy.tool.mail.smtp.ssl"] = "true"
//            //开启debug调试，控制台会打印相关信息
//            props!!["com.pandy.tool.mail.debug"] = "true"
//            val sf = MailSSLSocketFactory()
//            sf.isTrustAllHosts = true
//            props!!["com.pandy.tool.mail.smtp.ssl.enable"] = "true"
//            props!!["com.pandy.tool.mail.smtp.ssl.socketFactory"] = sf
//            val authenticator: Authenticator = object : Authenticator() {
//                override fun getPasswordAuthentication(): PasswordAuthentication {
//                    //发件人邮箱账号
//                    val userId = props!!.getProperty("userId", "390346484@qq.com")
//                    //发件人邮箱密码(qq、163等邮箱用的是授权码,outlook是密码)
//                    val password = props!!.getProperty("password", "vgiawnyaguyybiei")
//                    return PasswordAuthentication(userId, password)
//                }
//            }
//            session = Session.getInstance(props, authenticator)
//            val message = MimeMessage(session)
//            message.setFrom(InternetAddress(fromEmail))
//            message.addRecipient(Message.RecipientType.TO, InternetAddress(toEmail))
//            //标题
//            message.subject = "这是一条测试标题"
//            //面试开始时间
//            val startTime = getUtc("2020-11-06 18:00")
//            //面试结束时间
//            val endTime = getUtc("2020-11-06 20:00")
//            val buffer = StringBuffer()
//            buffer.append(
//                """
//                        BEGIN:VCALENDAR
//                        PRODID:-//Microsoft Corporation//Outlook 9.0 MIMEDIR//EN
//                        VERSION:2.0
//                        METHOD:CANCEL
//                        BEGIN:VEVENT
//                        ATTENDEE;ROLE=REQ-PARTICIPANT;RSVP=TRUE:MAILTO:你和应聘者
//                        DTSTART:$startTime
//                        DTEND:$endTime
//                        LOCATION:会议室01
//                        UID:8888
//                        CATEGORIES:
//                        SUMMARY:面试邀请
//                        PRIORITY:5
//                        CLASS:PUBLIC
//                        BEGIN:VALARM
//                        TRIGGER:-PT10M
//                        ACTION:DISPLAY
//                        DESCRIPTION:Reminder
//                        END:VALARM
//                        END:VEVENT
//                        END:VCALENDAR
//                        """.trimIndent()
//            )
//            val messageBodyPart: BodyPart = MimeBodyPart()
//            messageBodyPart.dataHandler = DataHandler(
//                ByteArrayDataSource(
//                    buffer.toString(),
//                    "text/calendar;method=REQUEST;charset=\"UTF-8\""
//                )
//            )
//            val multipart = MimeMultipart()
//            val mimeBodyPart = MimeBodyPart()
//            //String emailText = getHtmlContent(sendEmailApi.getTemplateContent(tempValue),tempMap);
//            //文本类型正文
//            mimeBodyPart.setText("尊敬的先生:\r您好！\r特邀您参加...")
//            //html类型正文
//            //mimeBodyPart.setContent(emailText,"text/html;charset=UTF-8");
//            //添加正文
//            multipart.addBodyPart(mimeBodyPart)
//            //添加日历
//            multipart.addBodyPart(messageBodyPart)
//            message.setContent(multipart)
//            message.sentDate = Date()
//            message.saveChanges()
//            Transport.send(message)
//        } catch (me: MessagingException) {
//            me.printStackTrace()
//        } catch (ex: Exception) {
//            ex.printStackTrace()
//        }
//    }
//
//    /**
//     * 转utc时间
//     *
//     * @param str
//     * @return
//     */
//    private fun getUtc(str: String): String {
//        val sdf = SimpleDateFormat("yyyy-MM-dd HH:mm")
//        var millionSeconds: Long = 0
//        try {
//            millionSeconds = sdf.parse(str).time
//        } catch (e1: ParseException) {
//            e1.printStackTrace()
//        }
//        //utc时间差8小时
//        val currentTime = millionSeconds - 8 * 60 * 60 * 1000
//        val date = Date(currentTime)
//        //格式化日期
//        val df: DateFormat = SimpleDateFormat("yyyy-MM-dd HH:mm:ss")
//        var nowTime = ""
//        nowTime = df.format(date)
//        //转换utc时间
//        return nowTime.replace("-", "").replace(" ", "T").replace(":", "")
//    }
//}
