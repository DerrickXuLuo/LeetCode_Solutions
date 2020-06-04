
/**
 * @Author Derrick
 * @CreateTime 6/4/2020 3:24 PM
 * @Desc
 */
public class LC213 {
    public int rob(int[] nums) {
        if (nums == null || nums.length == 0){
            return 0;
        }

        //If we rob the first house, we cannot rob the last house. Thus, we can solve this problem by starting our robbing on two starting points.
        return Math.max(rob(nums, 0, nums.length - 2), rob(nums, 1, nums.length - 1));
    }

    /**
     * The solution is similar to LC198(House Robber), we just need to modify the range of the array.
     * @param nums
     * @param l
     * @param r
     * @return
     */
    private int rob(int[] nums, int l, int r){
        int[] dp = new int[r - l + 2];
        dp[1] = nums[l];
        for (int i = 2; i < dp.length; i++){
            dp[i] = Math.max(dp[i - 2] + nums[i - 1 + l], dp[i - 1]);
        }

        return dp[dp.length - 1];
    }
}
