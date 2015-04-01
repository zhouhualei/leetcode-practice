package me.warren.leetcode;

/**
 * Created by warzhou1 on 3/29/15.
 */
public class Solution136 {

    public int singleNumber1(int[] A) {
        int single = 0;
        int count[] = new int[32];
        for(int i=0; i<count.length; i++)
            count[i] = 0;

        for (int i=0; i<A.length; i++) {
            for(int j=0; j<count.length; j++) {
                count[j] += (A[i] & 1);
                count[j] %= 2;
                A[i] = A[i] >> 1;
            }
        }

        for(int i=0; i<count.length; i++) {
            single += (count[i] << i);
        }

        return single;
    }

    public int singleNumber(int[] A) {
        int single = 0;
        for (int i=0; i<A.length; i++) {
            single ^= A[i];
        }
        return single;
    }

    public static void main(String[] args) {

        Solution136 solution = new Solution136();
        int[] a = new int[] {1,2,3,3,2,1,5};
        System.out.println(solution.singleNumber(a));

        int[] b = new int[] {};
        System.out.println(solution.singleNumber(b));

    }
}
