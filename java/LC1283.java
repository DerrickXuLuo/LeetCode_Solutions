class Solution {
    public int smallestDivisor(int[] nums, int threshold) {
        int left = 1, right = (int)1e6;
        while (left < right) {
            int m = left + (right - left) / 2, sum = 0;
            for (int num : nums) {
                sum += num % m == 0 ? num / m : num / m + 1;
            }
            if (sum > threshold) {
                left = m + 1;
            } else {
                right = m;
            }
        }

        return left;
    }
}
