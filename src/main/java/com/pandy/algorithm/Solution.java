package com.pandy.algorithm;

import java.util.*;

/**
 * @author Pandy
 * reverse代表后半部分的翻转
 */
public class Solution {

    /**
     * 判断是够是回文字符串
     * 数学
     * @param x
     * @return
     */
    public static boolean isPalindrome(int x) {
        // 0是回文数
        if (x == 0) return true;
        // 负数和除0以外以0结尾的都不是回文数
        if (x < 0 || x % 10 == 0) return false;
        int reversed = 0; // reversed: 4 43 433 4333 43332
        while (x > reversed) { // x%10: 4 3 3 3 2
            // 记录x后一半的翻转 x = 101 reversed = 1 x = 4334 reversed = 43
            reversed = reversed * 10 + x % 10;
            x /= 10; // x: 43332333 4333233 433323 43332
        }
        // x有偶数位和奇数位两种情况
        return x == reversed || x == reversed / 10;
    }

    /**
     * 判断字符是否唯一
     * @param astr
     * @return
     */
    public boolean isUnique(String astr) {
        Set set = new HashSet();
        for (char c : astr.toCharArray()) {
            set.add(c);
        }
        return set.size() == astr.length();
    }

    /**
     * 字符串重新排列后 能否成为另一个字符串
     * @param s1
     * @param s2
     * @return
     */
    public static boolean CheckPermutation(String s1, String s2) {
        HashMap<Object, Integer> map1 = new HashMap();
        HashMap<Object, Integer> map2 = new HashMap();
        for (char c : s1.toCharArray()) {
            if (map1.containsKey(c)) {
                map1.put(c, map1.get(c) + 1);
            }else {
                map1.put(c, 1);
            }
        }

        for (char c : s2.toCharArray()) {
            if (map2.containsKey(c)) {
                map2.put(c, map2.get(c) + 1);
            }else {
                map2.put(c, 1);
            }
        }
        return map1.equals(map2);
    }

    /**
     * url化
     * @param S
     * @param length
     * @return
     */
    public static String replaceSpaces(String S, int length) {

        if (!S.contains(" ") && S.length() == length) {
            return S;
        }

        LinkedList l = new LinkedList();
        if (S.length() > length) {
            for (char c : S.toCharArray()) {
                l.add(c);
            }
            for (int i = 0; i < S.length() - length; i++) {
                l.removeLast();
            }
        }

        StringBuilder stringBuilder =new StringBuilder();

        int flag = 0;
        for (Object c : l) {
            final String s = String.valueOf(c);
            if (s.equals(" ")) {
                flag ++;
                stringBuilder.append("%20");
            }else {
                stringBuilder.append(s);
            }
        }
        return stringBuilder.toString();
    }

    public static void main(String[] args) {
        System.out.println(isPalindrome(433323334));
        System.out.println(CheckPermutation("abcc", "ccba1"));
        System.out.println(replaceSpaces("LqyuIZCuyRyvllekBuYNUZDrCzHCXeeUmZAfgIvHxzFgLCkLLzDBdfJh", 56));
    }
}
