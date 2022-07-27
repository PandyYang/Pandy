package com.pandy.algorithm.huawei.jishi;

import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Scanner;
import java.util.Set;

/**
 * @author Pandy
 */
public class BuChongFu {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        final String s = in.nextLine();
        StringBuilder sb = new StringBuilder(s);
        StringBuilder sb2 = new StringBuilder();
        Set set = new LinkedHashSet<String>();
        final char[] chars = sb.reverse().toString().toCharArray();
        for (char c : chars) {
            set.add(c);
        }

        final Iterator iterator = set.iterator();

        while (iterator.hasNext()) {
            sb2.append(iterator.next());
        }

        System.out.println(Integer.valueOf(sb2.toString()));
    }
}
