/**
 * @Author Derrick
 * @CreateTime 6/25/2020 4:32 PM
 * @Desc The main idea is same as the problem LinkedList Cycle II.
 * There are two loops in the solution, the first one is to find the cycle,
 * the second one is to find the entrance of the cycle, which is the the duplicate element.
 */
public class LC287 {
    public int findDuplicate(int[] nums) {
        int slow = nums[0], fast = nums[0];
        //We should use do-while loop here cause the slow must be equal to fast at the beginning.
        do {
            slow = nums[slow];
            fast = nums[nums[fast]];
        }while (slow != fast);

        slow = nums[0];
        while (slow != fast){
            slow = nums[slow];
            fast = nums[fast];
        }
        return fast;
    }
}
