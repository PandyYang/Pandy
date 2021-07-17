package com.pandy.algorithm.offer.question;

public class JumpFloorII {
    public static int jump2(int target) {
        if (target <= 0) {
            return -1;
        } else if (target == 1) {
            return 1;
        } else {
            return 2 * jump2(target -1 );
        }
    }

    public static int jump(int target) {
        if (target <= 0) {
            return -1;
        } else if (target == 1) {
            return 1;
        } else if (target == 2) {
            return 2;
        } else {
            return jump(target -1) + jump(target - 2);
        }
    }
}
