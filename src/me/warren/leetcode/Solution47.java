package me.warren.leetcode;

import java.util.*;

/**
 * Created by warzhou1 on 3/29/15.
 *
 * Time complexity: O(n!)
 */
public class Solution47 {

    public List<List<Integer>> permuteUnique(int[] num) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();

        Arrays.sort(num);

        // get num counter
        HashMap<Integer, Integer> counterMap = new HashMap<Integer, Integer>();
        for (int i = 0; i < num.length; i++) {
            if(i == 0) {
                counterMap.put(num[i], 1);
            } else {
                if(num[i] > num[i-1]) {
                    counterMap.put(num[i], 1);
                } else {
                    int originalCount = counterMap.get(num[i]);
                    counterMap.put(num[i], originalCount + 1);
                }
            }
        }

        permuteUniqueRecursive(counterMap, new ArrayList<Integer>(), result);
        return result;
    }

    private void permuteUniqueRecursive(Map counterMap, List path, List<List<Integer>> result) {

        if(counterMap.size() == 0) {
            result.add(path);
            return;
        }

        for(Integer key : (Set<Integer>)counterMap.keySet()) {
            int count = (Integer)counterMap.get(key);
            List<Integer> nextPath = new ArrayList<Integer>(path);
            Map<Integer, Integer> nextMap = new HashMap<Integer, Integer>(counterMap);
            nextPath.add(key);
            if(count == 1) {
                nextMap.remove(key);
            } else {
                nextMap.put(key, count - 1);
            }
            permuteUniqueRecursive(nextMap, nextPath, result);
        }
    }

    public static void main(String[] args) {

        Solution47 solution = new Solution47();
        //int[] num = {1,2,3,1,1};
        //int[] num = {1};
        int[] num = {};
        List<List<Integer>> result = solution.permuteUnique(num);
        System.out.println(result.size());
        for (List<Integer> line : result) {
            System.out.println(line);
        }
    }
}
