package com.company.dp;

/**
 * @Author Derrick
 * @CreateTime 7/4/2020 12:08 PM
 * @Desc
 */
public class LC416 {
    public boolean canPartition(int[] nums) {
        if (nums == null || nums.length == 0){
            return false;
        }

        int sum = 0;
        for (int num : nums){
            sum += num;
        }
        //If the sum of all the elements in the nums is odd, we can return false directly.
        if (sum % 2 != 0){
            return false;
        }
        //When dp[i][j] is true, it means: using elements whose index from 1st to i-th can fill the package whose capacity is j.
        int len = nums.length;
        boolean[][] dp = new boolean[len + 1][sum / 2 + 1];

        for (int j = 0; j < (sum / 2 + 1); j++){
            dp[0][j] = false;
        }
        for (int i = 0; i < len + 1; i++){
            dp[i][0] = true;
        }

        for (int i = 1; i < len + 1; i++){
            for (int j = 1; j < (sum / 2 + 1); j++){
                //If (j - nums[i - 1] < 0), the current elements cannot be added to the package because of short of capacity.
                //Cause the index of element starts at 1, so the nums[i - 1] represents the current element.
                if (j - nums[i - 1] < 0){
                    dp[i][j] = dp[i - 1][j];
                }else {
                    //When the capacity is enough, we can choose whether to add the current element or not.
                    dp[i][j] = dp[i - 1][j] || dp[i - 1][j - nums[i - 1]];
                }
            }
        }

        return dp[len][sum / 2];
    }
}
