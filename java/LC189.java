
/**
 * @Author Derrick
 * @CreateTime 6/3/2020 12:03 AM
 * @Desc
 */
public class LC189 {
    /**
     * Using extra array: Time Complexity: O(n). Space Complexity: O(n).
     * @param nums
     * @param k
     */
    public static void rotate(int[] nums, int k) {
        if (nums == null || nums.length == 0){
            return;
        }

        int len = nums.length;
        k %= len;

        int[] tmp = new int[len];
        //For the right hand part
        for (int i = 0; i < k; i++){
            tmp[i] = nums[len - k + i];
        }
        //For the left hand part
        for (int i = k; i < len; i++){
            tmp[i] = nums[i - k];
        }

        for (int i = 0; i < tmp.length; i++){
            nums[i] = tmp[i];
        }
    }

    public static void main(String[] args){
        int[] arr = new int[]{1, 2, 3, 4, 5, 6, 7};
        rotate(arr, 3);
    }

    /**
     * Using reverse: Time = O(n). Space = O(1)
     * @param nums
     * @param k
     */
    public static void rotateII(int[] nums, int k) {
        if (nums == null || nums.length == 0){
            return;
        }

        k %= nums.length;
        reverse(nums, 0, nums.length - 1);
        reverse(nums, 0, k - 1);
        reverse(nums, k, nums.length - 1);
    }

    private static void reverse(int[] nums, int start, int end){
        while (start < end){
            int tmp = nums[start];
            nums[start] = nums[end];
            nums[end] = tmp;
            start++;
            end--;
        }
    }
}
