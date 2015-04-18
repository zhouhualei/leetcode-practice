package me.warren.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by warzhou1 on 3/29/15.
 */
public class Solution22 {

    public List<String> generateParenthesis(int n) {
        List<String> parStringList = new ArrayList<String>();
        recursiveGenerate(parStringList, new String(), 0, n, n);
        return parStringList;
    }

    private void recursiveGenerate(List<String> parStringList, String curString, int depth, int leftRemain, int rightRemain) {

        if(leftRemain == 0 && rightRemain == 0 && depth == 0) {
            parStringList.add(curString);
            return;
        }

        if(depth == 0) {
            recursiveGenerate(parStringList, curString + '(', depth+1, leftRemain-1, rightRemain);
        } else if(depth > 0) {
            if(leftRemain > 0) {
                recursiveGenerate(parStringList, curString + '(', depth+1, leftRemain-1, rightRemain);
            }
            if(rightRemain > 0) {
                recursiveGenerate(parStringList, curString + ')', depth-1, leftRemain, rightRemain-1);
            }
        }
        return;
    }


    public static void main(String[] args) {
        Solution22 solution = new Solution22();
        List<String> parStringList = solution.generateParenthesis(1);
        for (String parString : parStringList) {
            System.out.println(parString);
        }
    }
}
