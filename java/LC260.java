
/**
 * @Author Derrick
 * @CreateTime 6/20/2020 12:29 PM
 * @Desc
 */
public class LC260 {
    public int[] singleNumber(int[] nums) {
        if (nums == null || nums.length == 0){
            return new int[]{};
        }

        int diff = 0;
        for (int num : nums){
            diff ^= num;
        }
        //Find out the last 1 bit
        diff &= -diff;

        int[] ans = new int[]{0, 0};
        for (int num : nums){
            //Split the nums array into two parts implicitly
            if ((num & ans[0]) == 0){
                ans[0] ^= num;
            }else {
                ans[1] ^= num;
            }
        }

        return ans;
    }
}
