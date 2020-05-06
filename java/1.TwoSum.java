class Solution {
    /**
     * One pass Hashmap solution: Time Complexity = O(n); Space Complexity = O(n)
     * @param nums
     * @param target
     * @return
     */
    public int[] twoSum(int[] nums, int target) {
        if (nums == null || nums.length == 0){
            return new int[]{};
        }

        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++){
            int rem = target - nums[i];
            if (map.containsKey(rem)){
                return new int[]{i, map.get(rem)};
            }else {
                map.put(nums[i], i);
            }
        }

        return new int[]{};
    }
}
