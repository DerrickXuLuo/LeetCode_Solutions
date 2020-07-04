package com.company.dp;

/**
 * @Author Derrick
 * @CreateTime 6/30/2020 7:23 PM
 * @Desc
 */
public class LC518 {
    /**
     * DFS with memo
     * @param amount
     * @param coins
     * @return
     */
    public int change(int amount, int[] coins) {
        Integer[][] dp = new Integer[coins.length][amount + 1];
        return dfs(amount, coins, 0, dp);
    }

    private int dfs(int amount, int[] coins, int idx, Integer[][] dp){
        if (amount == 0){
            return 1;
        }else if (amount < 0 || idx == coins.length){
            return 0;
        }

        if (dp[idx][amount] != null){
            return dp[idx][amount];
        }

        //Two options: 1. Use the current coin. 2. Don't use the current coin.
        //When we choose the option 1, we don't need to increase the index, cause we can use a coin multiple times.
        //But if we choose the option 2, we need to increase the index.
        int selected = dfs(amount - coins[idx], coins, idx, dp);
        int notSelected = dfs(amount, coins, idx + 1, dp);

        dp[idx][amount] = selected + notSelected;
        return dp[idx][amount];
    }

    /**
     * DP: Time = O(M*N), M represents amount, N represents types of coins.
     * dp[j][i] represents the number of combinations that uses j types of coins to make up amount i.
     * @param amount
     * @param coins
     * @return
     */
    public int changeII(int amount, int[] coins) {
        int[][] dp = new int[coins.length + 1][amount + 1];
        dp[0][0] = 1;
        for (int j = 1; j <= coins.length; j++){
            dp[j][0] = 1;
            for (int i = 1; i <= amount; i++){
                dp[j][i] = dp[j - 1][i];
                //If (i - coins[j - 1]) is greater than 0, it means that the current coin can be chosen to be one of the combinations.
                if (i - coins[j - 1] >= 0){
                    dp[j][i] += dp[j][i - coins[j - 1]];
                }
            }
        }

        return dp[coins.length][amount];
    }

    public static void main(String[] args) {
//        change(5, new int[]{1,2,5});
    }
}
