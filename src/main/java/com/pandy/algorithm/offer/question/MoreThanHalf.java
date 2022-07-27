package com.pandy.algorithm.offer.question;

import java.util.Arrays;

public class MoreThanHalf {

    public int MoreThanHalfNum_Solution(int[] array) {
        Arrays.sort(array);
        return array[array.length / 2];
    }
}
