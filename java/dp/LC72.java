package com.company.dp;

/**
 * @Author Derrick
 * @CreateTime 7/5/2020 11:55 PM
 * @Desc
 */
public class LC72 {
    public int minDistance(String word1, String word2) {
        if (word1 == null || word1.length() == 0 || word2 == null || word2.length() == 0){
            return 0;
        }

        int[][] dp = new int[word1.length() + 1][word2.length() + 1];

        for (int i = 0; i < word1.length() + 1; i++){
            for (int j = 0; j < word2.length() + 1; j++){
                if (i == 0){
                    dp[i][j] = j;
                    continue;
                }
                if (j == 0){
                    dp[i][j] = i;
                    continue;
                }

                //If the characters at the corresponding position are identical, we don't need to do anything.
                if (word1.charAt(i - 1) == word2.charAt(j - 1)){
                    dp[i][j] = dp[i - 1][j - 1];
                }else {
                    //If the characters at the corresponding position are not identical, we have three options:
                    //1. Insert a character. 2. Delete a character. 3. Replace a character.
                    //For the option 1, the number of operations is (1 + dp[i][j - 1])
                    //For the option 2, the number of operations is (1 + dp[i - 1][j])
                    //For the option 3, the number of operation is (1 + dp[i - 1][j - 1])
                    dp[i][j] = Math.min(1 + dp[i - 1][j - 1], 1 + Math.min(dp[i - 1][j], dp[i][j - 1]));
                }
            }
        }

        return dp[word1.length()][word2.length()];
    }
}
