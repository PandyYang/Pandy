package com.pandy.mail;

import com.sun.mail.util.MailSSLSocketFactory;

import javax.activation.DataHandler;
import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;
import javax.mail.util.ByteArrayDataSource;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Properties;

public class MeetingMail2 {
    public static void main(String[] args) {
        /**
         * 测试发送会议邀请邮件
         * done
         */
        sendMeetingInvitationEmail();

        /**
         * 测试撤销会议邀请邮件
         */
        //sendMeetingCancelEmail();
    }

    private static Properties props;
    private static Session session;

    /**
     * 发送会议邀请
     * fromEmail: 发送人
     * toEmail: 接收人
     * userId: 发件人邮箱账号
     * password: 发件人邮箱密码 例如QQ开启smtp之后需要使用授权码
     * subject: 标题
     * startTime: 会议开始时间
     * endTime: 会议结束时间
     * METHOD: 创建会议或者取消会议 REQUEST -> 为创建或者修改 CANCEL ->取消会议
     * SUMMARY: 会议描述
     * text: 会议正文
     * MAILTO: 参会者
     */
    public static void sendMeetingInvitationEmail() {
        try {
            props = new Properties();
            //发件人
            String fromEmail = props.getProperty("fromEmail", "390346484@qq.com");
            //收件人(面试官)
            String toEmail = props.getProperty("toEmail", "123@123.com");
            //String toEmail2 = props.getProperty("toEmail", "123@gmail.com");
            props.put("com.pandy.mail.smtp.port", "465");
            props.put("com.pandy.mail.smtp.host", "smtp.qq.com");
            //当前smtp host设为可信任 否则抛出javax.com.pandy.mail.MessagingException: Could not                   convert socket to TLS
            props.put("com.pandy.mail.smtp.ssl.trust", "smtp.qq.com");
            props.put("com.pandy.mail.transport.protocol", "smtp");
            props.put("com.pandy.mail.smtp.auth", "true");
            props.put("com.pandy.mail.smtp.starttls.enable", "true");
            props.put("com.pandy.mail.smtp.ssl", "true");
            //开启debug调试，控制台会打印相关信息
            //props.put("com.pandy.mail.debug", "true");
            MailSSLSocketFactory sf = new MailSSLSocketFactory();
            sf.setTrustAllHosts(true);
            props.put("com.pandy.mail.smtp.ssl.enable", "true");
            props.put("com.pandy.mail.smtp.ssl.socketFactory", sf);
            Authenticator authenticator = new Authenticator() {
                @Override
                protected PasswordAuthentication getPasswordAuthentication() {
                    //发件人邮箱账号
                    String userId = props.getProperty("userId", "390346484@qq.com");
                    //发件人邮箱密码(qq、163等邮箱用的是授权码,outlook是密码)
                    String password = props.getProperty("password", "vgiawnyaguyybiei");
                    return new PasswordAuthentication(userId, password);
                }
            };
            session = Session.getInstance(props, authenticator);
            MimeMessage message = new MimeMessage(session);
            message.setFrom(new InternetAddress(fromEmail));
            message.addRecipient(Message.RecipientType.TO, new InternetAddress(toEmail));
            //message.addRecipient(Message.RecipientType.TO, new InternetAddress(toEmail2));
            //标题
            message.setSubject("这是一条测试标题");
            //面试开始时间
            String startTime = getUtc("2020-11-10 18:00");
            //面试结束时间
            String endTime = getUtc("2020-11-10 20:00");
            StringBuffer buffer = new StringBuffer();
            buffer.append(
                    //起始
                    "BEGIN:VCALENDAR\n"
                            //对象的标志符
                            + "PRODID:-//Microsoft Corporation//Outlook 9.0 MIMEDIR//EN\n"
                            //版本
                            + "VERSION:2.0\n"
                            //事件类型
                            + "METHOD:REQUEST\n"
                            //时间开始
                            + "BEGIN:VEVENT\n"
                            //参会者
                            //+ "ATTENDEE;ROLE=REQ-PARTICIPANT;RSVP=TRUE:MAILTO:收到此邮件的人员\n"
                            //组织者
                            //+ "ORGANIZER:MAILTO:张三\n"
                            //开始时间
                            + "DTSTART:" + startTime + "\n"
                            //结束时间
                            + "DTEND:" + endTime + "\n"
                            //地点
                            + "LOCATION:会议室03\n"
                            //如果id相同的话，outlook会认为是同一个会议请求，所以使用uuid。//如果id相同的话，outlook会认为是同一个会议请求，所以使用uuid。
                            //+ "UID:" + UUID.randomUUID().toString() + "\n"
                            + "UID:" + 123 + "\n"
                            + "CATEGORIES:\n"
                            //会议描述
                            //+ "DESCRIPTION:Stay Hungry.<br>Stay Foolish.\n\n"
                            //事件概要
                            + "SUMMARY:面试邀请\n" + "PRIORITY:3\n"
                            + "CLASS:PUBLIC\n" + "BEGIN:VALARM\n"
                            //提前10分钟提醒
                            //+ "TRIGGER:-PT10M\n" + "ACTION:DISPLAY\n"
                            //+ "DESCRIPTION:Reminder\n" + "END:VALARM\n"
                            + "END:VEVENT\n" + "END:VCALENDAR"
            );
            BodyPart messageBodyPart = new MimeBodyPart();
            messageBodyPart.setDataHandler(new DataHandler(new ByteArrayDataSource(buffer.toString(),
                    "text/calendar;method=REQUEST;charset=\"UTF-8\"")));
            MimeMultipart multipart = new MimeMultipart();
            MimeBodyPart mimeBodyPart = new MimeBodyPart();
            //String emailText = getHtmlContent(sendEmailApi.getTemplateContent(tempValue),tempMap);
            //文本类型正文
            mimeBodyPart.setText("这是正文部分");
            //html类型正文
            //mimeBodyPart.setContent(emailText,"text/html;charset=UTF-8");
            //添加正文
            multipart.addBodyPart(mimeBodyPart);
            //添加日历
            multipart.addBodyPart(messageBodyPart);
            message.setContent(multipart);
            message.setSentDate(new Date());
            message.saveChanges();
            System.out.println(message);
            Transport.send(message);
        } catch (MessagingException me) {
            me.printStackTrace();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    /**
     * 撤销会议邀请
     *
     * @throws Exception
     */
    public static void sendMeetingCancelEmail() {
        try {
            props = new Properties();
            //发件人
            String fromEmail = props.getProperty("fromEmail", "390346484@qq.com");
            //收件人(面试官)
            String toEmail = props.getProperty("toEmail", "123@outlook.com");
            props.put("com.pandy.mail.smtp.port", "465");
            props.put("com.pandy.mail.smtp.host", "smtp.qq.com");
            //当前smtp host设为可信任 否则抛出javax.com.pandy.mail.MessagingException: Could not                   convert socket to TLS
            props.put("com.pandy.mail.smtp.ssl.trust", "smtp.qq.com");
            props.put("com.pandy.mail.transport.protocol", "smtp");
            props.put("com.pandy.mail.smtp.auth", "true");
            props.put("com.pandy.mail.smtp.starttls.enable", "true");
            props.put("com.pandy.mail.smtp.ssl", "true");
            //开启debug调试，控制台会打印相关信息
            props.put("com.pandy.mail.debug", "true");
            MailSSLSocketFactory sf = new MailSSLSocketFactory();
            sf.setTrustAllHosts(true);
            props.put("com.pandy.mail.smtp.ssl.enable", "true");
            props.put("com.pandy.mail.smtp.ssl.socketFactory", sf);
            Authenticator authenticator = new Authenticator() {
                @Override
                protected PasswordAuthentication getPasswordAuthentication() {
                    //发件人邮箱账号
                    String userId = props.getProperty("userId", "390346484@qq.com");
                    //发件人邮箱密码(qq、163等邮箱用的是授权码,outlook是密码)
                    String password = props.getProperty("password", "vgiawnyaguyybiei");
                    return new PasswordAuthentication(userId, password);
                }
            };
            session = Session.getInstance(props, authenticator);
            MimeMessage message = new MimeMessage(session);
            message.setFrom(new InternetAddress(fromEmail));
            message.addRecipient(Message.RecipientType.TO, new InternetAddress(toEmail));
            //标题
            message.setSubject("这是一条测试标题");
            //面试开始时间
            String startTime = getUtc("2020-11-06 18:00");
            //面试结束时间
            String endTime = getUtc("2020-11-06 20:00");
            StringBuffer buffer = new StringBuffer();
            buffer.append("BEGIN:VCALENDAR\n"
                    + "PRODID:-//Microsoft Corporation//Outlook 9.0 MIMEDIR//EN\n"
                    + "VERSION:2.0\n"
                    + "METHOD:CANCEL\n" //REQUEST:创建和更新会议  CANCEL:取消会议 保证uuid相同 才可以取消 所以要存数据库
                    + "BEGIN:VEVENT\n"
                    //参会者
                    + "ATTENDEE;ROLE=REQ-PARTICIPANT;RSVP=TRUE:MAILTO:你和应聘者\n"
                    //组织者
                    //+ "ORGANIZER:MAILTO:张三\n"
                    + "DTSTART:" + startTime + "\n"
                    + "DTEND:" + endTime + "\n"
                    //面试地点
                    + "LOCATION:会议室01\n"
                    //如果id相同的话，outlook会认为是同一个会议请求，所以使用uuid。 //如果需要取消会议 则uuid和前一个一样
                    //+ "UID:" + UUID.randomUUID().toString() + "\n"
                    + "UID:" + 8888 + "\n"
                    + "CATEGORIES:\n"
                    //会议描述
                    //+ "DESCRIPTION:Stay Hungry.<br>Stay Foolish.\n\n"
                    + "SUMMARY:面试邀请\n" + "PRIORITY:5\n"
                    + "CLASS:PUBLIC\n" + "BEGIN:VALARM\n"
                    //提前10分钟提醒
                    + "TRIGGER:-PT10M\n" + "ACTION:DISPLAY\n"
                    + "DESCRIPTION:Reminder\n" + "END:VALARM\n"
                    + "END:VEVENT\n" + "END:VCALENDAR");
            BodyPart messageBodyPart = new MimeBodyPart();
            messageBodyPart.setDataHandler(new DataHandler(new ByteArrayDataSource(buffer.toString(),
                    "text/calendar;method=REQUEST;charset=\"UTF-8\"")));
            MimeMultipart multipart = new MimeMultipart();
            MimeBodyPart mimeBodyPart = new MimeBodyPart();
            //String emailText = getHtmlContent(sendEmailApi.getTemplateContent(tempValue),tempMap);
            //文本类型正文
            mimeBodyPart.setText("尊敬的先生:\r您好！\r特邀您参加...");
            //html类型正文
            //mimeBodyPart.setContent(emailText,"text/html;charset=UTF-8");
            //添加正文
            multipart.addBodyPart(mimeBodyPart);
            //添加日历
            multipart.addBodyPart(messageBodyPart);
            message.setContent(multipart);
            message.setSentDate(new Date());
            message.saveChanges();
            Transport.send(message);
        } catch (MessagingException me) {
            me.printStackTrace();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    /**
     * 转utc时间
     *
     * @param str
     * @return
     */
    private static String getUtc(String str) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm");
        long millionSeconds = 0;
        try {
            millionSeconds = sdf.parse(str).getTime();
        } catch (ParseException e1) {
            e1.printStackTrace();
        }
        //utc时间差8小时
        long currentTime = millionSeconds - 8 * 60 * 60 * 1000;
        Date date = new Date(currentTime);
        //格式化日期
        DateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String nowTime = "";
        nowTime = df.format(date);
        //转换utc时间
        String utcTime = nowTime.replace("-", "").replace(" ", "T").replace(":", "");
        return utcTime;
    }
}
