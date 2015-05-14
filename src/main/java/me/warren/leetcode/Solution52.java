package me.warren.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by warzhou1 on 4/17/15.
 * <p/>
 * Problem: N-Queens
 * Time complexity: O(n!)
 */
public class Solution52 {

    public int totalNQueens(int n) {
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
        return solveNQueensRecursive(mainDiagonal, antiDiagonal, columnUsed, columnNums, 0, 0, n);
    }

    private int solveNQueensRecursive(List<Boolean> mainDiagonal, List<Boolean> antiDiagonal, List<Boolean> columnUsed, List<Integer> columnNums, Integer totalSolution, int rowNum, int n) {
        if (rowNum == n) {
            return ++totalSolution;
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

                totalSolution = solveNQueensRecursive(nextMainDiagonal, nextAntiDiagonal, nextColumnUsed, nextColumnNums, totalSolution, rowNum + 1, n);
            }
        }
        return totalSolution;
    }

    public static void main(String[] args) {
        Solution52 solution = new Solution52();
        System.out.println(solution.totalNQueens(4));;
    }
}
