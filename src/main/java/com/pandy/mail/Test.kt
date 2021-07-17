import java.util.*
import javax.activation.DataHandler
import javax.mail.internet.MimeBodyPart
import javax.mail.internet.MimeMultipart
import javax.mail.util.ByteArrayDataSource
import kotlin.collections.HashMap

data class MeetingMailDetails(
    val METHOD: String?,
    val DTSTART: Date,
    val DTEND: Date,
    val LOCATION: String,
    val UUID: String
)

class MeetingMail {

    /**
     * @param startTime 会议开始时间
     * @param endTime 会议结束时间
     * @param address 会议地址
     * @param method 新增更新或撤销操作 REQUEST or CANCLE
     * @param map<k,v> k为邮件唯一性标识uuid v为邮件主题内容
     */
    fun sendMeetingInvitationEmail(meetingMailDetails: MeetingMailDetails) {
        //邮件唯一性标识
        val randomCode = UUID.randomUUID().toString()
        val map = HashMap<String, String>()
        val buffer = StringBuffer()
        val m = meetingMailDetails.toString()
        buffer.append(
            """
            BEGIN:VCALENDAR
            PRODID:-//Microsoft Corporation//Outlook 9.0 MIMEDIR//EN
            VERSION:2.0
            BEGIN:VEVENT
            $m
            CLASS:PUBLIC
            END:VEVENT
            END:VCALENDAR
        """.trimIndent()
        )
        val multipart = MimeMultipart()
        val messageBodyPart = MimeBodyPart()
        messageBodyPart.dataHandler = DataHandler(
            ByteArrayDataSource(
                buffer.toString(),
                "text/calendar;method=REQUEST;charset=\"UTF-8\""
            )
        )
        // 添加会议邀请内容
        multipart.addBodyPart(messageBodyPart)
        multipart.preamble
        println(multipart.toString())
    }

}

fun main() {
    val uuid = UUID.randomUUID().toString()
    val meetingMailDetails = MeetingMailDetails(
        METHOD = "REQUEST",
        DTSTART = Date(2020, 11, 7, 18, 20, 20),
        DTEND = Date(2020, 11, 7, 19, 20, 20),
        LOCATION = "会议室01",
        UUID = uuid
    )
    MeetingMail().sendMeetingInvitationEmail(meetingMailDetails)

}
