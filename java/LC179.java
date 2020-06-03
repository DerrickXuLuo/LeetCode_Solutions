
/**
 * @Author Derrick
 * @CreateTime 6/2/2020 6:22 PM
 * @Desc Primitive idea: modify the integer in the nums to string, then override a comparator to sort the strings in descending order.
 * Time Complexity: For sorting an array basically, it will take O(NLogN). 
 * For each comparing step, it will take O(K). K represents the average length of the strings.
 * Thus, the overall time complexity is O(K*NLogN).
 */
public class LC179 {
    public String largestNumber(int[] nums) {
        if (nums == null || nums.length == 0){
            return "";
        }

        String[] strArr = new String[nums.length];
        for (int i = 0; i < nums.length; i++){
            strArr[i] = String.valueOf(nums[i]);
        }

        Comparator<String> comparator = new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                String strA = o1 + o2;
                String strB = o2 + o1;
                return strB.compareTo(strA);
            }
        };

        Arrays.sort(strArr, comparator);
        //Edge case: only 0 in the array
        if (strArr[0].charAt(0) == '0'){
            return "0";
        }

        StringBuilder ans = new StringBuilder();
        for (String str : strArr){
            ans.append(str);
        }

        return ans.toString();
    }
}
