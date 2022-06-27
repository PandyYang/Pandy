package com.pandy.base.array;


public class sumSubString {
    public static void main(String[] args) {
        sumSubString sumSubString = new sumSubString();

//        int i = test.sumSubString("a ", " ");
        int i = sumSubString.sumSubString("abc ", " ");

        System.out.println("i = " + i);

        System.out.println("Math.sqrt(-1) = " + Math.sqrt(-1));
    }

    private int sumSubString(String a, String b){
        int sub = 0;
        while (a.contains(b)) {
            sub++;
            a = a.replaceFirst(b, "");
        }
        return sub;
    }
}
