public class LC15 {
    public List<List<Integer>> threeSum(int[] nums) {
        if (nums == null || nums.length == 0){
            return new ArrayList<>();
        }

        //Sort the array
        Arrays.sort(nums);
        List<List<Integer>> ans = new ArrayList<>();

        for (int i = 0; i < nums.length; i++){
            if (nums[i] > 0){
                break;
            }

            //Remove the duplicate results by checking whether nums[i - 1] is equals to nums[i] or not
            if (i == 0 || (i > 0 && nums[i - 1] != nums[i])){
                int k = -nums[i], l = i + 1, r = nums.length - 1;
                while (l < r){
                    if (nums[l] + nums[r] == k){
                        ans.add(Arrays.asList(nums[i], nums[l], nums[r]));
                        //Remove the duplicate nums[l] and nums[r]
                        while (l < r && nums[l] == nums[l + 1]){
                            l++;
                        }
                        while (l < r && nums[r - 1] == nums[r]){
                            r--;
                        }
                        l++;
                        r--;
                    }else if (nums[l] + nums[r] < k){
                        l++;
                    }else {
                        r--;
                    }
                }
            }
        }

        return ans;
    }
}
