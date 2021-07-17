package com.pandy.algorithm.offer.question;

import java.util.LinkedList;
import java.util.List;

/**
 * 约瑟夫环
 */
public class LastRemaining {
    public int lastRemaining(int n, int m) {
        List<Integer> list = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            list.add(i);
        }
        int bt = 0;
        while (list.size() > 1) {
            bt = (bt + m -1) %list.size();
            list.remove(bt);
        }
        return list.size() == 1 ? list.get(0) : -1;
    }
}
