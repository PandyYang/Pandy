package com.pandy.tool.dateformat;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * @author Pandy
 * @date 26/1/2022
 */
public class DateFormat {

    public String stringToDate(String data) {

        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyyMMddHHmmss");

        LocalDateTime ldt = LocalDateTime.parse(data, dtf);
//
//        System.out.println(ldt);

        DateTimeFormatter fa = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

        String datetime2 = ldt.format(fa);

        return datetime2;
    }
}
