/**
 * @Author Derrick
 * @CreateTime 6/22/2020 6:07 PM
 * @Desc DP solution: we need to multiply the existed ugly numbers by 2, 3, 5 to get a bigger ugly number,
 * however, every existed number can multiply the 2, 3, 5 once and only once.
 * Thus, we can maintain three pointers to memorize the positions of the three factors.
 */
public class LC264 {
    public int nthUglyNumber(int n) {
        int[] dp = new int[n];
        dp[0] = 1;
        int index2 = 0, index3 = 0, index5 = 0;
        int factor2 = 2, factor3 = 3, factor5 = 5;
        for (int i = 1; i < n; i++){
            //Because we are looking for the n-th smallest ugly number, we need to get the minimum numbers of three factors.
            int min = Math.min(Math.min(factor2, factor3), factor5);
            dp[i] = min;
            if (factor2 == min){
                factor2 = 2 * dp[++index2];
            }
            if (factor3 == min){
                factor3 = 3 * dp[++index3];
            }
            if (factor5 == min){
                factor5 = 5 * dp[++index5];
            }
        }

        return dp[n - 1];
    }
}
