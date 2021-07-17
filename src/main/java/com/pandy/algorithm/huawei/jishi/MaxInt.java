package com.pandy.algorithm.huawei.jishi;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class MaxInt {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String sc = scanner.next();
        List list = new ArrayList();
        for (int i = 0; i < sc.length(); i++) {
            list.add(sc.charAt(i));
        }
        for (int i = 0; i < list.size(); i++) {
            for (int j = 0; j < i; j++) {
                if (list.get(i).equals(list.get(j))) {
                    if (Integer.valueOf(list.get(j + 1).toString()) > Integer.valueOf(list.get(j).toString())) {
                        list.remove(j);
                        i--;
                        break;
                    } else {
                        list.remove(i);
                        i--;
                        break;
                    }
                }
            }
        }
        for (int j = 0; j < list.size(); j++) {
            System.out.print(list.get(j));
        }
    }
}
