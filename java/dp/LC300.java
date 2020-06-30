package com.company.dp;

import java.util.Arrays;

/**
 * @Author Derrick
 * @CreateTime 6/28/2020 10:31 PM
 * @Desc
 */
public class LC300 {
    /**
     * DP: Time = O(N^2), Space = O(N^2)
     * Main idea: Maintain an array arr[], arr[i] represents (the number of elements before nums[i] that are less than nums[i]) + 1.
     * For each element in the nums[], we need to check all of the previous elements, if the nums[j] is less than nums[i], we can update to the
     * temporary variable len.
     * After traversing the elements before nums[i], we can get the length of the longest subsequence which is ending at nums[i].
     * @param nums
     * @return
     */
    public static int lengthOfLIS(int[] nums) {
        if (nums == null || nums.length == 0){
            return 0;
        }

        int[] arr = new int[nums.length];
        arr[0] = 1;
        int globalMax = 1;
        for (int i = 1; i < nums.length; i++){
            int len = 0;
            for (int j = 0; j < i; j++){
                if (nums[j] < nums[i]){
                    len = Math.max(len, arr[j]);
                }
            }
            len += 1;
            arr[i] = len;
            globalMax = Math.max(globalMax, len);
        }

        return globalMax;
    }

    /**
     * DFS without memo: Time = O(2^N)
     * DFS with memo: Time = O(N^2)
     * memo[i][j] represents the length of LIS using nums[i] as the previous element, and with nums[j] as the current element.
     * Set the initial values in the memo to be 1, then check the values of the memo during the process of backtracking, if the memo[i][j] is
     * greater than 0, which means that the length of LIS between nums[i] and nums[j] has been calculated, so we can skip this branch.
     * @param nums
     * @return
     */
    public static int lengthOfLISII(int[] nums) {
        int[][] memo = new int[nums.length + 1][nums.length];
//        return helperII(nums, Integer.MIN_VALUE, 0);
        for (int[] arr : memo){
            Arrays.fill(arr, -1);
        }

        return helperII(nums, -1, 0, memo);
    }

    //Without memorization
    private static int helperII(int[] nums, int prev, int currPos){
        if (currPos == nums.length){
            return 0;
        }

        int canAppend = 0;
        if (nums[currPos] > prev){
            canAppend = 1 + helperII(nums, nums[currPos], currPos + 1);
        }
        int canNotAppend = helperII(nums, prev, currPos + 1);

        return Math.max(canAppend, canNotAppend);
    }

    //With memorization
    private static int helperII(int[] nums, int prevIndex, int currPos, int[][] memo){
        if (currPos == nums.length){
            return 0;
        }
        if (memo[prevIndex + 1][currPos] >= 0){
            return memo[prevIndex + 1][currPos];
        }

        int canAppend = 0;
        if (prevIndex < 0 || nums[currPos] > nums[prevIndex]){
            canAppend = 1 + helperII(nums, currPos, currPos + 1, memo);
        }
        int canNotAppend = helperII(nums, prevIndex, currPos + 1, memo);
        memo[prevIndex + 1][currPos] = Math.max(canAppend, canNotAppend);

        return memo[prevIndex + 1][currPos];
    }

    /**
     * DP with Binary Search: Time = O(NLogN)
     * @param nums
     * @return
     */
    public static int lengthOfLISIII(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }

        int[] tails = new int[nums.length];
        int globalMax = 0;
        for (int num : nums){
            int i = 0, j = globalMax;
            while (i != j){
                int m = i + (j - i) / 2;
                if (tails[m] < num){
                    i = m + 1;
                }else {
                    j = m;
                }
            }
            tails[i] = num;
            if (i == globalMax){
                globalMax++;
            }
        }

        return globalMax;
    }

    public static void main(String[] args) {
        lengthOfLIS(new int[]{10,9,2,5,3,7,101,18});
    }
}
