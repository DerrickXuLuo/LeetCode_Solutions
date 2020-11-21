class Solution {
    public int[] sortArray(int[] nums) {
        if (nums == null || nums.length == 0) {
            return nums;
        }
        return helper(nums, 0, nums.length - 1);
    }
    
    private int[] helper(int[] nums, int left, int right) {
        int pivotIndex = partition(nums, left, right);
        
        if (pivotIndex > left) {
            helper(nums, left, pivotIndex - 1);
        } else if (pivotIndex < right) {
            helper(nums, pivotIndex + 1, right);
        }
        
        return nums;
    }
    
    private int partition(int[] nums, int left, int right) {
        int pivotValue = nums[right];
        int idx = left - 1;
        for(int i = left; i < right; i++) {
            if (nums[i] <= pivotValue) {
                idx++;
                swap(nums, i, idx);
            }
        }
        
        swap(nums, idx + 1, right);
        return idx + 1;
    }
    
    private void swap(int[] nums, int i, int j) {
        int tmp = nums[j];
        nums[j] = nums[i];
        nums[i] = tmp;
    }
}
