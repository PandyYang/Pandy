package com.pandy.algorithm.common;

public class StringMatcher {
    public static int indexOf(String source, String pattern) {
        int i = 0;
        int j = 0;
        int sLen = source.length(), pLen = pattern.length();
        char[] src = source.toCharArray();
        char[] ptn = pattern.toCharArray();

        while (i < sLen && j < pLen) {
            if (src[i] == ptn[j]) {
                i++;
                j++;
            } else {
                i = i - j + 1;
                j = 0;
            }
        }

        if (j == pLen) {
            return i - j;
        } else {
            return -1;
        }
    }

    public static int index2(String source, String pattern) {
        int i = 0; int j = 0;
        char[] src = source.toCharArray();
        char[] ptn = pattern.toCharArray();
        int sLen = src.length;
        int pLen = ptn.length;
        int[] next = getNext(ptn);
        while (i < sLen && j < pLen) {
            if (src[i] == ptn[j]) {
                i++;
                j++;
            } else {
                j = next[j];
            }
        }

        if (j == pLen) {
            return i - j;
        } else {
            return -1;
        }

    }

    public static int[] getNext(char[] p) {
        int plen = p.length;
        int[] next = new int[plen];
        int k = -1;
        int j = 0;
        next[0] = -1;
        while (j < plen - 1){
            if (k == -1 || p[j] == p[k]) {
                k++;
                j++;
                next[j] = k;
            } else {
                k = next[k];
            }
        }
        return next;
    }

    public static void main(String[] args) {
        System.out.println(indexOf("12312907304601273091273", "12907"));
    }
}
