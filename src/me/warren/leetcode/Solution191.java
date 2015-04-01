package me.warren.leetcode;

/**
 * Created by warzhou1 on 3/29/15.
 */
public class Solution191 {

    public int hammingWeight(int n) {

        int count=0;
        for(int i=0;i<32;i++){
            count=count+(n&1);
            n=n>>>1;
        }
        return count;
    }

    public static void main(String[] args) {

        Solution191 solution = new Solution191();
        int n = 3;
        System.out.println(solution.hammingWeight(n));

    }
}
