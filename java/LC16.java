public class LC16 {
    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);

        int dev = Integer.MAX_VALUE, ans = 0;
        for (int i = 0; i < nums.length; i++){
            int l = i + 1, r = nums.length - 1;
            while (l < r){
                int sum = nums[i] + nums[l] + nums[r];
                if (sum == target){
                    return sum;
                }else if (sum < target){
                    l++;
                }else {
                    r--;
                }

                if (Math.abs(sum - target) < dev){
                    dev = Math.abs(sum - target);
                    ans = sum;
                }
            }
        }

        return ans;
    }
}
