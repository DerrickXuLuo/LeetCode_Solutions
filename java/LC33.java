public class LC33 {
    /**
     * Modified binary search, Time Complexity = O(LogN)
     * @param nums
     * @param target
     * @return
     */
    public int search(int[] nums, int target) {
        int l = 0, r = nums.length - 1;

        while (l <= r){
            int m = l + (r - l) / 2;

            if (target == nums[m]){
                return m;
            }

            if (nums[r] > nums[l]){
                //Case1: The subarray is in ascending order, the traditional binary search can be implemented
                if (target < nums[m]){
                    r = m - 1;
                }else {
                    l = m + 1;
                }
            }else {
                //Case2: The subarray is not monotonically increasing, the modified binary search should be implemented
                //[4,5,6,7, | 0,1,2] Assume that the array is divided into two sections.
                if (nums[m] < nums[r]){ //Case2.1: the medium element lies on the right sections.
                    if (target > nums[m] && target <= nums[r]){ //The target can only be lay on the right of the medium element.
                        l = m + 1;
                    }else {
                        r = m - 1;
                    }
                }else { //Case2.2: the medium element lies on the left section.
                    if (target < nums[m] && target >= nums[l]){//The target can only be lay on the left of the medium element.
                        r = m - 1;
                    }else {
                        l = m + 1;
                    }
                }

            }
        }

        return -1;
    }
}
