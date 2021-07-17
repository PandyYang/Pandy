package com.pandy.algorithm;
import java.util.*;
import java.util.regex.*;

public class Main {

    public static void main(String[] args) {
//        Scanner in = new Scanner(System.in);
//        //输入参数
//        String a = in.next();
        // 3+2*(1+2*(-4/(8-6)+7))
//        System.out.println(getResult("3+2*{1+2*[-4/(8-6)+7]}"));
//        System.out.println(getResult("3+2*(1+2*(2/(8-6)+7))"));
        System.out.println(getResult("-2+1"));
    }

    public static int getResult(String input) {
        Pattern pattern = Pattern.compile("((?<![\\d)])-?\\d+(\\.\\d+)?|[+\\-*/()])");// 匹配数字和运算符
        input = input.replaceAll("[{\\[]", "(").replaceAll("[}\\]]", ")");//替换其他类型的括号
        Matcher matcher = pattern.matcher(input);
        Stack<String> number = new Stack<>(); // 操作数栈
        Stack<String> operator = new Stack<>(); // 操作数栈
        operator.push("null"); // 操作数栈头部放入
        while (matcher.find()) {
            String temp = matcher.group();
            if (temp.matches("[()]")) { // 括号
                if ("(".equals(temp)) { // 左括号入站
                    operator.push("(");
                } else {
                    String b = null;
                    while (!(b = operator.pop()).equals("(")) { // 右括号，弹出，直到遇到左括号，将新的计算结果入栈
                        number.push(calculate(b, number.pop(), number.pop()));
                    }
                }
            } else if (temp.matches("[+\\-*/]")) { // 运算符
                // 判断当前符号跟栈顶符号的优先级，如果优先级大，直接入栈
                if (getPriority(temp) > getPriority(operator.peek())) {
                    operator.push(temp);
                } else {
                    // 如果优先级小，出栈计算，直到遇到优先级大的，重新入栈
                    while (getPriority(temp) <= getPriority(operator.peek())) {
                        number.push(calculate(operator.pop(), number.pop(), number.pop()));
                    }
                    operator.push(temp);
                }
            } else {
                // 数字直接入站
                number.push(temp);
            }
        }
        // 遍历结束后，依次弹出操作数，出栈计算，后入站
        while (number.size() > 1) {
            number.push(calculate(operator.pop(), number.pop(), number.pop()));
        }
        return (int) Double.parseDouble(number.pop());
    }

    // 返回设定符号的优先级
    private static int getPriority(String b) {
        switch (b) {
            case "+":
            case "-":
                return 1;
            case "*":
            case "/":
                return 2;
        }
        return 0;
    }

    private static String calculate(String b, String a1, String a2) {
        double result = 0;
        double d1 = Double.parseDouble(a2);
        double d2 = Double.parseDouble(a1);
        switch (b) {
            case "+":
                result = d1 + d2;
                break;
            case "-":
                result = d1 - d2;
                break;
            case "*":
                result = d1 * d2;
                break;
            case "/":
                result = d1 / d2;
                break;
        }
        return result + "";
    }
}
