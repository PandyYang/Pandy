package com.pandy.algorithm.huaweiod;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class GetMaxLengthDigtalString {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNext()) {
            String next = in.next();
            Pattern pattern = Pattern.compile("[0-9]+(\\.[0-9]+)?");
            Matcher matcher = pattern.matcher(next);
            List<String> list = new ArrayList<>();
            int j = 0;
            while (matcher.find(j)) {
                list.add(matcher.group());
                j = matcher.start() + 1;
            }
            String result = "";
            for (String s : list) {
                if (s.length() >= result.length()) {
                    result = s;
                }
            }
            System.out.println(result);
        }
    }
}
