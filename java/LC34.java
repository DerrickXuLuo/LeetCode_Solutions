public class LC34 {
    public static int[] searchRange(int[] nums, int target) {
        if (nums == null || nums.length == 0){
            return new int[]{};
        }

        int[] targetRange = new int[]{-1, -1};
        int leftIdx = modifiedBSearch(nums, target, true);

        if (leftIdx == nums.length || nums[leftIdx] != target){
            return targetRange;
        }

        targetRange[0] = leftIdx;
        targetRange[1] = modifiedBSearch(nums, target, false) - 1;

        return targetRange;
    }

    private static int modifiedBSearch(int[] nums, int target, boolean left){
        int l = 0, r = nums.length - 1;

        //If the left is equals to true, the method will return leftmost position of the target.
        //Otherwise, the method will return (rightmost position of the target + 1).
        while (l < r){
            int m = l + (r - l) / 2;
            if (nums[m] > target || (left && nums[m] == target)){
                r = m;
            }else {
                l = m + 1;
            }
        }

        return l;
    }

    public static void main(String[] args){
        int[] nums = new int[]{5,7,7,8,8,10};
        modifiedBSearch(nums, 8, false);
    }
}
