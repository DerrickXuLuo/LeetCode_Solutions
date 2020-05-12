public class LC26 {
    public int removeDuplicates(int[] nums) {
        if (nums == null || nums.length == 0){
            return 0;
        }

        int i = 1, j = 1;
        while (j < nums.length){
            if (nums[j] != nums[i - 1]){
                nums[i++] = nums[j];
            }
            j++;
        }

        return i;
    }
}
