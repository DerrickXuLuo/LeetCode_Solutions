public class LC27 {
    public int removeElement(int[] nums, int val) {
        if (nums == null || nums.length == 0){
            return 0;
        }

        int i = 0, j = 0;
        while (j < nums.length){
            if (nums[j] != val){
                nums[i++] = nums[j];
            }
            j++;
        }

        return i;
    }
}
