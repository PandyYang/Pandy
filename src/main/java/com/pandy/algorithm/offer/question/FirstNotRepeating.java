package com.pandy.algorithm.offer.question;

import java.util.HashMap;

/**
 * 第一个只出现一次的字符
 */
public class FirstNotRepeating {
    HashMap<Character, Integer> map = new HashMap<>();

    public int FirstNotRepeatingChar(String str) {
        if (str==null)return -1;
        int length = str.length();
        for(int i = 0;i<length;i++) {

            if(map.containsKey(str.charAt(i))){
                int value = map.get(str.charAt(i));
                map.remove(str.charAt(i));
                map.put(str.charAt(i),value+1);
            }else{
                map.put(str.charAt(i),1);
            }
        }
        for(int i = 0;i<length;i++){
            if(map.get(str.charAt(i))==1)
                return i;
        }
        return -1;
    }
}
