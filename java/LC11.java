public class LC11 {
    /**
     * Time Complexity = O(n)
     * Proved by contradiction:
     * https://leetcode.com/problems/container-with-most-water/discuss/6089/Anyone-who-has-a-O(N)-algorithm/7268
     * @param height
     * @return
     */
    public int maxArea(int[] height) {
        int maxArea = 0, l = 0, r = height.length - 1;
        while (l < r){
            maxArea = Math.max(maxArea, (r - l) * Math.min(height[l], height[r]));
            if (height[l] < height[r]){
                l++;
            }else {
                r--;
            }
        }

        return maxArea;
    }
}
