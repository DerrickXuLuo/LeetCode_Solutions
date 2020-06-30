package com.company.dp;

import java.util.Arrays;

/**
 * @Author Derrick
 * @CreateTime 6/28/2020 6:18 PM
 * @Desc
 */
public class LC322 {
    /**
     * Brute force: Time limit exceeded, Time Complexity: O(N^amount), N is types of coins.
     * @param coins
     * @param amount
     * @return
     */
    static int globalMin = Integer.MAX_VALUE;
    public static int coinChange(int[] coins, int amount) {
        dfsBF(coins, amount, 0);
        return globalMin == Integer.MAX_VALUE ? -1 : globalMin;
    }

    private static void dfsBF(int[] coins, int amount, int count){
        if (amount == 0){
            globalMin = Math.min(globalMin, count);
            return;
        }

        if (amount > 0){
            for (int coin : coins){
                dfsBF(coins, amount - coin, count + 1);
            }
        }
    }

    /**
     * DFS with memorization (Top-Down): Time = O(amount * N)
     * @param coins
     * @param amount
     * @return
     */
    public static int coinChangeII(int[] coins, int amount) {
        return dfsMemo(coins, amount, new int[amount]);
    }

    private static int dfsMemo(int[] coins, int rem, int[] memo){
        if (rem < 0){
            return -1;
        }else if (rem == 0){
            return 0;
        }

        //If the sub-problem has been calculated, we just need to return the corresponding value.
        if (memo[rem - 1] != 0){
            return memo[rem - 1];
        }

        int min = Integer.MAX_VALUE;
        for (int coin : coins){
            int ans = dfsMemo(coins, rem - coin, memo);
            if (ans >= 0 && ans < min){
                min = 1 + ans;
            }
        }

        memo[rem - 1] = (min == Integer.MAX_VALUE) ? -1 : min;
        return memo[rem - 1];
    }

    /**
     * DP (Bottom-Up): dp[i] represents the minimum number of coins using to build the value i.
     * @param coins
     * @param amount
     * @return
     */
    public static int coinChangeIII(int[] coins, int amount) {
        if (amount < 0){
            return -1;
        }else if (amount == 0){
            return 0;
        }

        int max = amount + 1;
        int[] dp = new int[amount + 1];
        Arrays.fill(dp, max);
        dp[0] = 0;
        for (int i = 1; i <= amount; i++){
            for (int j = 0; j < coins.length; j++){
                if (coins[j] <= i){
                    dp[i] = Math.min(dp[i], dp[i - coins[j]] + 1);
                }
            }
        }
        return dp[amount] > amount ? -1 : dp[amount];
    }


        public static void main(String[] args) {
        System.out.println(coinChangeII(new int[]{1,2,5}, 5));
    }
}
