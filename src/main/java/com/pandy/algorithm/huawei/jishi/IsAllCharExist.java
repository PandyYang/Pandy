package com.pandy.algorithm.huawei.jishi;

import java.util.HashSet;
import java.util.Set;

public class IsAllCharExist {

    // 使用set判断是否包含
    public boolean isAllCharExist(String pShortString, String pLongString) {
        Set<Character> set = new HashSet<>();
        for (char ch : pLongString.toCharArray()) {
            set.add(ch);
        }

        for (char ch : pShortString.toCharArray()) {
            if (!set.contains(ch)) {
                return false;
            }
        }
        return true;
    }
}
