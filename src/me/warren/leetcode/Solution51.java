package me.warren.leetcode;

import java.util.*;

/**
 * Created by warzhou1 on 4/17/15.
 * <p/>
 * Problem: N-Queens
 * Time complexity: O(n!)
 */
public class Solution51 {

    public List<String[]> solveNQueens(int n) {
        List<String[]> result = new ArrayList<String[]>();

        List<Boolean> mainDiagonal = new ArrayList<Boolean>(2 * n);
        List<Boolean> antiDiagonal = new ArrayList<Boolean>(2 * n);
        for (int i = 0; i < 2 * n; i++) {
            mainDiagonal.add(false);
            antiDiagonal.add(false);
        }

        List<Boolean> columnUsed = new ArrayList<Boolean>(n);
        for (int i = 0; i < n; i++) {
            columnUsed.add(false);
        }
        List<Integer> columnNums = new ArrayList<Integer>(n);
        for (int i = 0; i < n; i++) {
            columnNums.add(-1);
        }
        solveNQueensRecursive(mainDiagonal, antiDiagonal, columnUsed, columnNums, result, 0, n);
        return result;
    }

    private void solveNQueensRecursive(List<Boolean> mainDiagonal, List<Boolean> antiDiagonal, List<Boolean> columnUsed, List<Integer> columnNums, List<String[]> result, int rowNum, int n) {
        if (rowNum == n) {
            String[] solution = new String[n];
            for (int i = 0; i < n; i++) {
                StringBuffer line = new StringBuffer();
                for (int j = 0; j < n; j++) {
                    if (j == columnNums.get(i)) {
                        line.append('Q');
                    } else {
                        line.append('.');
                    }
                }
                solution[i] = line.toString();
            }
            result.add(solution);
            return;
        }

        // iterate all the columns
        for (int i = 0; i < n; i++) {
            if (!columnUsed.get(i) && !mainDiagonal.get(rowNum + i) && !antiDiagonal.get(rowNum + n - i)) {

                List<Boolean> nextMainDiagonal = new ArrayList<Boolean>(mainDiagonal);
                List<Boolean> nextAntiDiagonal = new ArrayList<Boolean>(antiDiagonal);
                List<Boolean> nextColumnUsed = new ArrayList<Boolean>(columnUsed);
                List<Integer> nextColumnNums = new ArrayList<Integer>(columnNums);

                nextColumnNums.set(rowNum, i);
                nextColumnUsed.set(i, true);
                nextMainDiagonal.set(rowNum + i, true);
                nextAntiDiagonal.set(rowNum + n - i, true);

                solveNQueensRecursive(nextMainDiagonal, nextAntiDiagonal, nextColumnUsed, nextColumnNums, result, rowNum + 1, n);
            }
        }
    }

    public static void main(String[] args) {

        Solution51 solution = new Solution51();
        List<String[]> result = solution.solveNQueens(4);
        System.out.println(result.size());
        for (String[] line : result) {
            for (int i = 0; i < line.length; i++) {
                System.out.println(line[i]);
            }
            System.out.println();
        }
    }
}
