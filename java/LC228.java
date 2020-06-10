
/**
 * @Author Derrick
 * @CreateTime 6/10/2020 11:52 AM
 * @Desc
 */
public class LC228 {
    public List<String> summaryRanges(int[] nums) {
        if (nums == null || nums.length == 0){
            return new ArrayList<>();
        }

        List<String> list = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        sb.append(nums[0]);
        for (int i = 1; i < nums.length; i++){
            //If the final element can be included in the current range, we need to append it to the current sb.
            if (i == nums.length - 1 && nums[i] == nums[i - 1] + 1){
                sb.append("->");
                sb.append(nums[i]);
            }
            //If the current element is larger than last element plus 1, and the current range consists of more than ONE element, 
            //we need to append last element to the current sb, then create a new sb using the current element, which means that we are starting a new range.
            if (nums[i] > nums[i - 1] + 1 && nums[i - 1] != Integer.parseInt(sb.toString())){
                sb.append("->");
                sb.append(nums[i - 1]);
                list.add(sb.toString());
                sb = new StringBuilder();
                sb.append(nums[i]);
            }else if (nums[i] > nums[i - 1] + 1){
                list.add(sb.toString());
                sb = new StringBuilder();
                sb.append(nums[i]);
            }
        }
        list.add(sb.toString());

        return list;
    }

    public static void main(String[] args){
        StringBuilder sb = new StringBuilder();

    }
}
