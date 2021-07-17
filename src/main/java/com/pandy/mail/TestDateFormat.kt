import java.text.DateFormat
import java.text.ParseException
import java.text.SimpleDateFormat
import java.util.*

fun main() {
    val sdf = SimpleDateFormat("yyyy-MM-dd HH:mm:ss")
    val startTime = sdf.parse("2020-11-13 20:10:12")
    val endTime = sdf.parse("2020-11-13 21:10:12")

    val data = sdf.format(startTime)
    println(data.toString())
    println(data)
    println(getUtc(data))

    val s = Date()
    println(s)
    println("转换前的值： $s, 转化后的值：${getUtc(data)}t")
    println("转换前的值： $s, 转化后的值：${getUtc2(s)}t")
    println("转换前的值： $s, 转化后的值：${getUtc3(s)}t")
//    getUtc(startTime.toString())
}

private fun getUtc(str: String): String {
    //获取指定格式的毫秒值
    val sdf = SimpleDateFormat("yyyy-MM-dd HH:mm")
    var millionSeconds: Long = 0
    try {
        millionSeconds = sdf.parse(str).time
    } catch (e1: ParseException) {
        e1.printStackTrace()
    }
    //utc时间差8小时
    val currentTime = millionSeconds - 8 * 60 * 60 * 1000
    val date = Date(currentTime)
    //格式化日期
    val df: DateFormat = SimpleDateFormat("yyyy-MM-dd HH:mm:ss")
    var nowTime = ""
    nowTime = df.format(date)
    //转换utc时间
    return nowTime.replace("-", "").replace(" ", "T").replace(":", "")
}

private fun getUtc2(date: Date): String {
    val millionSeconds = date.time
    val currentTime = millionSeconds - 8 * 60 * 60 * 1000
    val currentDate = Date(currentTime)
    val dateFormat = SimpleDateFormat("yyy-MM-dd HH:mm:ss")
    val nowTime = dateFormat.format(currentDate)
    return nowTime.replace("-", newValue = "").replace(" ", newValue = "T").replace(":", newValue = "")
}

fun getUtc3(date: Date): String {
    val dateFormat = SimpleDateFormat("yyyyMMdd'T'HHmmss")
    dateFormat.timeZone = TimeZone.getTimeZone("UTC")
    return dateFormat.format(date)
}
