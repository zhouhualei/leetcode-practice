package me.warren.leetcode;

import java.util.Arrays;

/**
 * Created by warzhou1 on 3/29/15.
 */
public class Solution16 {

    public int threeSumClosest(int[] num, int target) {
        Arrays.sort(num);

        int sum = 0;
        int min_gap = Integer.MAX_VALUE;
        int abs_gap = Integer.MAX_VALUE;
        int length = num.length;
        for(int i=0; i<num.length-2; i++) {
            int j = i+1;
            int k = length -1;

            while(j < k) {
                int s = num[i] + num[j] + num[k];
                abs_gap = Math.abs(s - target);
                if(abs_gap < min_gap) {
                    min_gap = abs_gap;
                    sum = s;
                }
                if(s < target) {
                    j++;
                } else {
                    k--;
                }
            }
        }
        return sum;
    }

    public static void main(String[] args) {
        Solution16 solution = new Solution16();
        int[] a = new int[] {-1,2,1,-4};
        int target = -1;
        System.out.println(solution.threeSumClosest(a, target));
    }
}
