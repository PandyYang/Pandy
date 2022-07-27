package com.pandy.algorithm;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * @author 木已成舟
 * @date 2020/3/13
 */
public class Calculator {

    /**
     * 计算表达式的值
     *
     * @param s
     * @return
     */
    public int calculate(String s) {
        Queue<String> q = toSuffixExpression(s);
        System.out.println(solve(q));
        return solve(q);
    }

    /**
     * 将中缀表达式转化成后缀表达式
     *
     * @param s
     * @return
     */
    private Queue<String> toSuffixExpression(String s) {
        Stack<Character> stack = new Stack<>();
        Queue<String> queue = new LinkedList<>();
//        StringBuffer stringBuffer = new StringBuffer();

        int index = 0;
        while (index < s.length()) {
            char c = s.charAt(index);
            // 如果是数字，就入队列
            if (isDigital(c)) {
                // 入队的时候要判断后面是否还有剩余的数字，要把整个数字入队列，而不是一个数字字符
                int p = index;
                while (p < s.length() && isDigital(s.charAt(p))) {
                    p++;
                }
                queue.add(s.substring(index, p));
                index = p;
                continue;
                // 如果是左括号，就入栈
            } else if (c == '(') {
                stack.push(c);
                // 如果是右括号，就弹出栈中的元素，直到遇到左括号为止。左右括号均不入队列
            } else if (c == ')') {
                while ('(' != stack.peek()) {
                    queue.add(stack.pop() + "");
                }
                // 弹出左括号
                stack.pop();
                // 如果是运算符，分下面的情况讨论
            } else if (isOperator(c)) {
                // 如果符号栈为空，就直接压入栈
                if (stack.isEmpty()) {
                    stack.push(c);
                    // 如果符号栈的栈顶是左括号，则压入栈中
                } else if ('(' == stack.peek()) {
                    stack.push(c);
                    // 如果当前元素的优先级比符号栈的栈顶元素优先级高，则压入栈中
                } else if (priority(c) > priority(stack.peek())) {
                    stack.push(c);
                    // 如果此时遍历的运算符的优先级小于等于此时符号栈栈顶的运算符的优先级，
                    // 则将符号栈的栈顶元素弹出并且放到队列中，并且将正在遍历的符号压入符号栈
                } else if (priority(c) <= priority(stack.peek())) {
                    queue.add(stack.pop() + "");
                    stack.push(c);
                }
            }

            index++;
        }

        // 遍历完后，将栈中元素全部弹出到队列中
        while (!stack.isEmpty()) {
            queue.add(stack.pop() + "");
        }

        return queue;
    }

    /**
     * 后缀表达式求值
     *
     * @param queue
     * @return
     */
    public int solve(Queue<String> queue) {
        Stack<Integer> numberStack = new Stack<>();
        while (!queue.isEmpty()) {
            // 从队列中出队
            String s = queue.remove();
            // 如果是数字，就压入栈中
            if (isDigital(s.charAt(0))) {
                numberStack.push(Integer.parseInt(s));
                // 如果是运算符，就从栈中弹出两个元素
            } else if (isOperator(s.charAt(0))) {
                char c = s.charAt(0);
                int val1 = numberStack.pop();
                int val2 = numberStack.pop();
                switch (c) {
                    case '+': {
                        numberStack.push(val2 + val1);
                        break;
                    }
                    case '-': {
                        numberStack.push(val2 - val1);
                        break;
                    }
                    case '*': {
                        numberStack.push(val2 * val1);
                        break;
                    }
                    case '/': {
                        numberStack.push(val2 / val1);
                        break;
                    }
                }
            }
        }

        return numberStack.pop();
    }

    //判断是符号
    private boolean isOperator(char c) {
        return c == '+' || c == '-' || c == '*' || c == '/';
    }

    //判断是数字
    private boolean isDigital(char c) {
        return c >= '0' && c <= '9';
    }

    //运算符的优先级
    private int priority(char c) {
        switch (c) {
            case '+':
            case '-':
                return 1;
            case '*':
            case '/':
                return 2;
            default:
                throw new RuntimeException("Illegal operator:" + c);
        }
    }

}
