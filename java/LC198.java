*
 * @Author Derrick
 * @CreateTime 6/3/2020 11:24 AM
 * @Desc
 */
public class LC198 {
    /**
     * DP solution: Each element in the array dp represents
     * the maximum amount of money that I can rob up to now.
     * @param nums
     * @return
     */
    public int rob(int[] nums) {
        if (nums == null || nums.length == 0){
            return 0;
        }

        int[] dp = new int[nums.length + 1];
        dp[1] = nums[0];
        for (int i = 2; i < dp.length; i++){
            dp[i] = Math.max(dp[i - 2] + nums[i - 1], dp[i - 1]);
        }

        return dp[dp.length - 1];
    }
