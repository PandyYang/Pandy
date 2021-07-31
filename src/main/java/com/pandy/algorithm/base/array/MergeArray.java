package com.pandy.algorithm.base.array;

/**
 * @Author Pandy
 * @Date 2021/7/31 15:17
 */
public class MergeArray {
    public void merge(int A[], int m, int B[], int n) {
        int i = m-1, j = n-1, index = m+n-1;
        while (i >= 0 && j>=0) {
            A[index--] = A[i] > B[j] ? A[i--] : B[j--];
        }

        while (j >= 0) {
            A[index--] = B[j--];
        }
    }
}
