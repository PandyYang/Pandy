package com.pandy.algorithm.offer.question;

/**
 * 打印1到最大的n位数
 */
public class PrintToMaxOfNDigits {

    public static void main(String[] args) {
        PrintToMaxOfNDigits printToMaxOfNDigits = new PrintToMaxOfNDigits();
//        printToMaxOfNDigits.print(3);
//        printOneToNthDigits(1);
//        System.out.println(Arrays.toString(printNumbers(7)));
        printToMaxOfNDigits.print1ToMaxOfNDigits2(2);
    }

    public static void printOneToNthDigits(int n) {
        // 输入的数字不能为小于1
        if (n < 1) {
            throw new RuntimeException("The input number must larger than 0");
        }
        // 创建一个数组用于打存放值
        int[] arr = new int[n];
        printOneToNthDigits(0, arr);
    }

    /**
     * 输入数字n，按顺序打印出从1最大的n位十进制数。
     *
     * @param n   当前处理的是第个元素，从0开始计数
     * @param arr 存放结果的数组
     */
    public static void printOneToNthDigits(int n, int[] arr) {
        // 说明所有的数据排列选择已经处理完了
        if (n >= arr.length) {
            // 可以输入数组的值
            printArray(arr);
        } else {
            // 对
            for (int i = 0; i <= 9; i++) {
                arr[n] = i;
                printOneToNthDigits(n + 1, arr);
            }
        }
    }

    /**
     * 输入数组的元素，从左到右，从第一个非0值到开始输出到最后的元素。
     *
     * @param arr 要输出的数组
     */
    public static void printArray(int[] arr) {
        // 找第一个非0的元素
        int index = 0;
        while (index < arr.length && arr[index] == 0) {
            index++;
        }
        // 从第一个非0值到开始输出到最后的元素。
        for (int i = index; i < arr.length; i++) {
            System.out.print(arr[i]);
        }
        // 条件成立说明数组中有非零元素，所以需要换行
        if (index < arr.length) {
            System.out.println();
        }
    }

    public static int[] printNumbers(int n) {
        int end = (int) Math.pow(10, n) - 1;
        int[] array = new int[end];
        for (int i = 0; i < end; i++) {
            array[i] = i + 1;
        }
        return array;
    }

    public void print(int n) {
        int[] arr = new int[n];
        if (n <= 0)
            return;
        printArray(arr, 0);
    }

    private void printArray(int[] arr, int n) {
        for (int i = 0; i < 10; i++) {
            if (n != arr.length) {
                arr[n] = i;
                printArray(arr, n + 1);
            } else {
                boolean falg = false;
                for (int j = 0; j < arr.length; j++) {
                    if (arr[j] != 0) {
                        System.out.print(arr[j]);
                        if (!falg)
                            falg = true;
                    } else {
                        if (falg)
                            System.out.print(arr[j]);
                    }
                }
                System.out.println();
                return;
            }
        }
    }

    public void print1ToMaxOfNDigits2(int n) {
        if (n < 1) {
            return;
        }
        char[] number = new char[n];
        for (int i = 0; i < number.length; i++) {
            number[i] = '0';
        }
        int count = 0;
        while (incrementNumber(number, n)) {
            printNumber(number);
            count++;
        }
        System.err.println("count = " + count);
    }

    private void printNumber(char[] num) {
        StringBuilder sb = new StringBuilder();
        boolean flag = false;
        for (int i = 0; i < num.length; i++) {
            if (flag) {
                sb.append(num[i]);
            } else if (num[i] != '0') {
                sb.append(num[i]);
                flag = true;
            }
        }
        System.err.println(sb);
    }

    private boolean incrementNumber(char[] number, int n) {
        int cur = n - 1;
        while (cur >= 0) {
            char num = number[cur];
            if (num < '9') {
                number[cur] = (char) (num + 1);
                return true;
            } else if (num == '9') {
                number[cur] = '0';
                cur--;
            }
        }
        return false;
    }

}
