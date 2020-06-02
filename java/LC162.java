/**
 * @Author Derrick
 * @CreateTime 6/1/2020 8:46 PM
 * @Desc
 */
public class LC162 {
    /**
     * Linear scan: Time = O(n)
     * @param nums
     * @return
     */
    public int findPeakElement(int[] nums) {
        if (nums == null || nums.length == 0){
            return 0;
        }

        for (int i = 1; i < nums.length - 1; i++){
            if (nums[i] > nums[i + 1]){
                return i;
            }
        }
        return nums.length - 1;
    }

    /**
     * Binary search: O(LogN)
     * @param nums
     * @return
     */
    public int findPeakElementII(int[] nums) {
        if (nums == null || nums.length == 0){
            return 0;
        }

        int l = 0, r = nums.length - 1;
        while (l < r){
            int m = l + (r - l) / 2;

            if (nums[m] < nums[m + 1]){
                l = m + 1;
            }else {
                r = m;
            }
        }

        return l;
    }
}
