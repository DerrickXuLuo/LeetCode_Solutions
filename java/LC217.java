
/**
 * @Author Derrick
 * @CreateTime 6/5/2020 11:14 AM
 * @Desc
 */
public class LC217 {
    public boolean containsDuplicate(int[] nums) {
        if (nums == null || nums.length == 0){
            return false;
        }

        Set<Integer> set = new HashSet<>();
        for (int num : nums){
            if (!set.add(num)){
                return true;
            }
        }

        return false;
    }
}
