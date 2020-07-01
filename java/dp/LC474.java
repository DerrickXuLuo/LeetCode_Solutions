package com.company.dp;

/**
 * @Author Derrick
 * @CreateTime 6/30/2020 2:37 PM
 * @Desc
 */
public class LC474 {
    static class Cell{
        int zNum;
        int oNum;
        public Cell(){}

        public Cell(int zNum, int oNum){
            this.zNum = zNum;
            this.oNum = oNum;
        }
    }

    /**
     * Primitive idea: For each string in the strs[], there are two choices we can make:
     * 1. Use the current string as one of the strings in the final result (if the remaining 0s and 1s are enough), in this case, we should add 1 to the final result.
     * 2. Skip the current string.
     * So actually, it is a very intuitive backtracking problem, but the time complexity will be O(2^N).
     * Thus, we need to maintain an extra 3-D array to optimize the time complexity to be O(k*m*n).
     * As for the 3-D array, memo[i][j][t] represents that the maximum number of strings can be selected from strs[0] to strs[t] while the initial numbers of 0 and 1 are i and j.
     * @param strs
     * @param m
     * @param n
     * @return
     */
    public static int findMaxForm(String[] strs, int m, int n) {
        Cell[] cells = new Cell[strs.length];
        for (int i = 0; i < strs.length; i++){
            cells[i] = new Cell();
            for (char ch : strs[i].toCharArray()){
                if (ch == '0'){
                    cells[i].zNum++;
                }else {
                    cells[i].oNum++;
                }
            }
        }

        int[][][] memo = new int[m + 1][n + 1][strs.length];

        return helper(cells, 0, m, n, memo);
    }

    private static int helper(Cell[] cells, int idx, int m, int n, int[][][] memo){
        if (cells.length == idx){
            return 0;
        }
        if (memo[m][n][idx] > 0){
            return memo[m][n][idx];
        }

        //selected
        int selected = 0;
        if (cells[idx].zNum <= m && cells[idx].oNum <= n){
            selected = 1 + helper(cells, idx + 1, m - cells[idx].zNum, n - cells[idx].oNum, memo);
        }
        //not selected
        int notSelected = 0;
        notSelected = helper(cells, idx + 1, m, n, memo);
        memo[m][n][idx] = Math.max(selected, notSelected);

        return memo[m][n][idx];
    }

    /**
     * DP solution: Time = O(k*m*n)
     * @param strs
     * @param m
     * @param n
     * @return
     */
    public static int findMaxFormII(String[] strs, int m, int n) {
        Cell[] cells = new Cell[strs.length];
        for (int i = 0; i < strs.length; i++){
            cells[i] = new Cell();
            for (char ch : strs[i].toCharArray()){
                if (ch == '0'){
                    cells[i].zNum++;
                }else {
                    cells[i].oNum++;
                }
            }
        }

        int[][] dp = new int[m + 1][n + 1];
        for (Cell cell : cells){
            for (int i = m; i >= cell.zNum; i--){
                for (int j = n; j >= cell.oNum; j--){
                    dp[i][j] = Math.max(1 + dp[i - cell.zNum][j - cell.oNum], dp[i][j]);
                }
            }
        }

        return dp[m][n];
    }

    public static void main(String[] args) {
        findMaxForm(new String[]{"10","0","1"}, 1, 1);
    }
}
