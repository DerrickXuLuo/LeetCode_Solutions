package com.company.dp;

/**
 * @Author Derrick
 * @CreateTime 7/5/2020 3:39 PM
 * @Desc
 */
public class LC583 {
    /**
     * DP:
     * @param word1
     * @param word2
     * @return
     */
    public int minDistance(String word1, String word2) {
        if (word1 == null || word1.length() == 0 || word2 == null || word2.length() == 0){
            return 0;
        }

        int len1 = word1.length(), len2 = word2.length();
        int[][] dp = new int[len1 + 1][len2 + 1];

        for (int i = 0; i < len1 + 1; i++){
            for (int j = 0; j < len2 + 1; j++){
                if (i == 0 || j == 0){
                    continue;
                }

                //If the corresponding characters in two strings are identical, we don't need deleting operation.
                if (word1.charAt(i - 1) == word2.charAt(j - 1)){
                    dp[i][j] = 1 + dp[i - 1][j - 1];
                }else {
                    //If the corresponding characters in two strings are not identical, we will have options:
                    //1.Delete the characters in the word1. 2.Delete the characters in the word1.
                    dp[i][j] = Math.max(dp[i][j - 1], dp[i - 1][j]);
                }
            }
        }

        return (len1 + len2) - 2 * dp[len1][len2];
    }

    /**
     * DFS with memo
     * @param word1
     * @param word2
     * @return
     */
    public int minDistanceII(String word1, String word2) {
        int[][] memo = new int[word1.length() + 1][word2.length() + 1];
        return word1.length() + word2.length() - 2 * dfs(word1, word2, word1.length(), word2.length(), memo);
    }

    private int dfs(String word1, String word2, int len1, int len2, int[][] memo){
        if (len1 == 0 || len2 == 0){
            return 0;
        }
        if (memo[len1][len2] > 0){
            return memo[len1][len2];
        }
        if (word1.charAt(len1) == word2.charAt(len2)){
            memo[len1][len2] = 1 + dfs(word1, word2, len1 - 1, len2 - 1, memo);
        }else {
            memo[len1][len2] = Math.max(dfs(word1, word2, len1 - 1, len2, memo), dfs(word1, word2, len1, len2 - 1, memo));
        }

        return memo[len1][len2];
    }
}
