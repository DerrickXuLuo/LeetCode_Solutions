package com.company.dp;

/**
 * @Author Derrick
 * @CreateTime 6/28/2020 4:21 PM
 * @Desc
 */
public class LC509 {
    /**
     * Brute force: Time = O(2^n)
     * @param N
     * @return
     */
    public int fib(int N) {
        if (N <= 1) {
            return N;
        }

        return fib(N - 1) + fib(N - 2);
    }

    /**
     * DFS with memorization (Top-down): Time = O(n)
     * @param N
     * @return
     */
    public int fibII(int N) {
        int[] memo = new int[N + 1];
        return dfsMemo(N, memo);
    }

    private int dfsMemo(int N, int[] memo) {
        if (N <= 1) {
            memo[N] = N;
            return N;
        }
        if (memo[N] != 0) {
            return memo[N];
        }

        memo[N] = dfsMemo(N - 1, memo) + dfsMemo(N - 2, memo);
        return memo[N];
    }

    /**
     * DP (Bottom-Up): Time = O(n), Space can be optimized to O(1).
     * @param N
     * @return
     */
    public int fibIII(int N) {
        if (N <= 1){
            return N;
        }

//        int[] dp = new int[N + 1];
//        for (int i = 2; i <= N; i++){
//            dp[i] = dp[i - 1] + dp[i - 2];
//        }
//
//        return dp[N];

        int prev = 0, curr = 1;
        for (int i = 2; i <= N; i++){
            int tmp = curr;
            curr = curr + prev;
            prev = tmp;
        }

        return curr;
    }
}
