package com.pandy.algorithm.huawei.jishi;

import java.util.Iterator;
import java.util.Scanner;
import java.util.TreeSet;

/**
 * @author Pandy
 */
public class SortAndRank {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            int num = scanner.nextInt();
            TreeSet treeSet = new TreeSet();
            for (int i = 0; i < num; i++) {
                treeSet.add(scanner.nextInt());
            }

            Iterator iterator = treeSet.iterator();
            while (iterator.hasNext()) {
                System.out.println(iterator.next());
            }
        }
    }
}
