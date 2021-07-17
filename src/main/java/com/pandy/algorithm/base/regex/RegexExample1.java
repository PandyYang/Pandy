package com.pandy.algorithm.base.regex;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegexExample1 {
    public static void main(String[] args) {
        String content = "123456789";
        String pattern = ".*4.*";
        boolean matches = Pattern.matches(pattern, content);
        System.out.println("是否包含了对应元素 " + matches);

        // 捕获组
        String line = "This order was placed for QT3000! OK?";
        String pattern2 = "(\\D*)(\\d+)(.*)";

        // 创建Pattern对象
        Pattern r = Pattern.compile(pattern2);

        Matcher m = r.matcher(line);
        if (m.find()) {
            for (int i = 0; i < m.groupCount(); i++) {
                System.out.println("Found value: " + m.group(i));
            }
        } else {
            System.out.println("no match");
        }

    }
}
