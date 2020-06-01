/**
 * @Author Derrick
 * @CreateTime 6/1/2020 2:26 PM
 * @Desc
 */
public class LC154 {
    public static int findMin(int[] nums) {
        int l = 0, r = nums.length - 1;

        while (l < r){
            int m = l + (r - l) / 2;

            if (nums[m] > nums[r]){
                l = m + 1;
            }else if (nums[m] < nums[r]){
                r = m;
            }else {
                if (nums[r - 1] > nums[r]){
                    l = r;
                    break;
                }
                r--;
            }
        }

        return nums[l];
    }

    public static void main(String[] args){
        findMin(new int[]{3,1,3});
    }
}
