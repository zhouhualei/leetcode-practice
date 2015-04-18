package me.warren.leetcode;

import java.util.ArrayList;
import java.util.List;

public class Solution118 {

    public List<List<Integer>> generate(int numRows) {
        ArrayList<List<Integer>> result = new ArrayList<List<Integer>>(numRows);
        for(int i=0; i<numRows; i++) {
            int len = i+1;
            ArrayList<Integer> line = new ArrayList<Integer>(len);
            if(len == 1)
                line.add(1);
            else if(len == 2) {
                line.add(1);
                line.add(1);
            } else {
                List<Integer> lastLine = result.get(i - 1);
                line.add(1);
                for (int j=1; j<len-1; j++) {
                    line.add(j, lastLine.get(j-1) + lastLine.get(j));
                }
                line.add(1);
            }
            result.add(line);
        }
        return result;
    }

    public static void main(String[] args) {
        int numRows = 2;
        Solution118 solution = new Solution118();
        List<List<Integer>> result = solution.generate(numRows);
        for (List<Integer> line : result) {
            for (Integer num : line) {
                System.out.print(num);
                System.out.print(' ');
            }

            System.out.println();
        }
    }

}
