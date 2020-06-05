
/**
 * @Author Derrick
 * @CreateTime 6/5/2020 11:38 AM
 * @Desc
 */
public class LC219 {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        if (nums == null || nums.length == 0){
            return false;
        }

        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++){
            //Check whether there is a duplicate element before, if there is a duplicate element before,
            //then we need to check whether the distance between the index of that element and the current element is less than or equal to k.
            //If the distance is larger than k, we need to update the index of the element, for only if we increase its index then the distance
            //might be decreased.
            if (map.containsKey(nums[i])) {
                int j = map.get(nums[i]);
                if (i - j <= k) {
                    return true;
                }
            }
            map.put(nums[i], i);
        }

        return false;
    }
}
