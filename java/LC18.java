public class LC18 {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        if (nums == null || nums.length == 0){
            return new ArrayList<>();
        }

        Arrays.sort(nums);
        List<List<Integer>> ans = new ArrayList<>();

        for (int i = 0; i < nums.length - 3; i++){
            if (i > 0 && nums[i] == nums[i - 1]){
                continue;
            }

            //3Sum
            int subTarget = target - nums[i];
            for (int j = i + 1; j < nums.length - 2; j++){
                if (j > i + 1 && nums[j] == nums[j - 1]){
                    continue;
                }

                int l = j + 1, r = nums.length - 1, k = subTarget - nums[j];
                //---The block of codes below can help reduce the time complexity.
                int twoSumMin = nums[l] + nums[l + 1], twoSumMax = nums[r - 1] + nums[r];
                if (k < twoSumMin || k > twoSumMax){
                    continue;
                }
                //---
                while (l < r){
                    if (nums[l] + nums[r] == k){
                        ans.add(Arrays.asList(nums[i], nums[j], nums[l], nums[r]));
                        while (l < r && nums[l] == nums[l + 1]){
                            l++;
                        }
                        while (l < r && nums[r] == nums[r - 1]){
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
