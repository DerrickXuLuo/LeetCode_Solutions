public class LC31 {
    public void nextPermutation(int[] nums) {
        if (nums == null || nums.length == 0){
            return;
        }

        int i = nums.length - 1;
        //Find the first "next greater element"
        while (i >= 1 && nums[i - 1] >= nums[i]){
            i--;
        }

        //Case1: Descending order
        if (i == 0){
            reverse(nums, 0, nums.length - 1);
            return;
        }else if (i == nums.length - 1){
            //Case2: Ascending order
            swap(nums, nums.length - 2, nums.length - 1);
            return;
        }

        int j = i;
        while (j < nums.length - 1){
            if (nums[j] > nums[i - 1] && nums[j + 1] <= nums[i - 1]){
                swap(nums, i - 1, j);
                break;
            }
            j++;
        }

        if (j == nums.length - 1){
            swap(nums, i - 1, j);
        }
        reverse(nums, i, nums.length - 1);
    }

    private void reverse(int[] nums, int i, int j){
        while (i < j){
            int tmp = nums[i];
            nums[i] = nums[j];
            nums[j] = tmp;
            i++;
            j--;
        }
    }

    private void swap(int[] nums, int i, int j){
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }
}
