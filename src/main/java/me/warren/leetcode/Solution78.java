package me.warren.leetcode;

import java.util.*;

/**
 * Created by warzhou1 on 3/10/15.
 */
public class Solution78 {

    public List<List<Integer>> subsetsRecursive(int[] S) {
        List<List<Integer>> subsets = new ArrayList<List<Integer>>();
        List<Integer> curList = new ArrayList<Integer>();
        Arrays.sort(S);
        subsetRecursiveInternal(subsets, S, curList, 0);
        return subsets;
    }

    private void subsetRecursiveInternal(List<List<Integer>> subsets, int[] S, List<Integer> curList, int curIndex) {

        if (curIndex == S.length) {
            List<Integer> path = new ArrayList<Integer>(curList);
            subsets.add(path);
            return;
        }

        // not choose current element
        subsetRecursiveInternal(subsets, S, curList, curIndex + 1);

        // choose current element
        List<Integer> nextList = new ArrayList<Integer>(curList);
        nextList.add(S[curIndex]);
        subsetRecursiveInternal(subsets, S, nextList, curIndex + 1);
    }

    public List<List<Integer>> subsetsInterative(int[] S) {
        List<List<Integer>> subsets = new ArrayList<List<Integer>>();

        return subsets;
    }

    public static void main(String[] args) {
        int[] S = {1, 2, 3};
        Solution78 solution = new Solution78();
        List<List<Integer>> result = solution.subsetsRecursive(S);
        for (List<Integer> set : result) {
            System.out.println(set.toString());
        }
    }
}
