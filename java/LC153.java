/**
 * @Author Derrick
 * @CreateTime 6/1/2020 12:45 PM
 * @Desc
 */
public class LC153 {
    /**
     * Time = O(N)
     * @param nums
     * @return
     */
    public int findMin(int[] nums) {
        int ans = nums[0], i = 1;
        while (i < nums.length){
            if (nums[i] < nums[i - 1]) {
                ans = nums[i];
                break;
            }
            i++;
        }

        return ans;
    }

    /**
     * Time = O(LogN)
     * @param nums
     * @return
     */
    public int findMinII(int[] nums) {
        int l = 0, r = nums.length - 1;

        //The list is in ascending order
        if (nums[r] >= nums[l]){
            return nums[l];
        }

        //Do the binary search
        while (r >= l){
            int m = l + (r - l) / 2;

            //Find the inflection point
            if (nums[m] > nums[m + 1]){
                return nums[m];
            }
            if (nums[m - 1] > nums[m]){
                return nums[m];
            }

            if (nums[m] > nums[0]){//The left part of the list is in ascending order, so the inflection point is on the right part.
                l = m + 1;
            }else {//The right part of the list is in ascending order, so the inflection point is on the left part.
                r = m - 1;
            }
        }

        return 0;
    }
}
