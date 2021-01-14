public class LC300 {
    //Brute force: O(N^2)
    public int lengthOfLIS(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }

        int[] dp = new int[nums.length];
        int maxLen = 1;

        for (int i = 0; i < nums.length; i++) {
            if (i == 0) {
                dp[i] = 1;
                continue;
            }

            for (int j = 0; j <= i; j++) {
                if (nums[i] > nums[j]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                } else {
                    dp[i] = Math.max(dp[i], 1);
                }
            }

            maxLen = Math.max(maxLen, dp[i]);
        }

        return maxLen;
    }

    //Optimized Solution
    public static int lengthOfLISII(int[] nums) {
        int[] tails = new int[nums.length];
        int size = 0;
        for (int x : nums) {
            int i = 0, j = size;
            while (i != j) {
                int m = (i + j) / 2;
                if (tails[m] < x) {
                    i = m + 1;
                } else {
                    j = m;
                }
            }
            tails[i] = x;
            if (i == size) {
                size++;
            }
        }

        return size;
    }

    public static void main(String[] args) {
        lengthOfLISII(new int[]{4,2,4,5,3,7});
    }
}
