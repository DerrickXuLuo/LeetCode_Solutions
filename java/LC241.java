
/**
 * @Author Derrick
 * @CreateTime 6/19/2020 5:56 PM
 * @Desc Divide and Conquer: when there is an operator, we can divide the expression into two parts and calculate their corresponding results.
 * In order to save time, we can maintain a map to memorize the substring and its corresponding result list. If we come to such a substring later,
 * we can just skip and go to the next character.
 */
public class LC241 {

    Map<String, List<Integer>> map = new HashMap<>();
    public List<Integer> diffWaysToCompute(String input) {
        if (map.containsKey(input)){
            return map.get(input);
        }

        List<Integer> ans = new ArrayList<>();
        for (int i = 0; i < input.length(); i++){
            if (input.charAt(i) == '-' || input.charAt(i) == '*' || input.charAt(i) == '+'){
                String lPart = input.substring(0, i);
                String rPart = input.substring(i + 1);
                List<Integer> lAns = diffWaysToCompute(lPart);
                List<Integer> rAns = diffWaysToCompute(rPart);
                for (Integer lSum : lAns){
                    for (Integer rSum : rAns){
                        int c = 0;
                        if (input.charAt(i) == '-'){
                            c = lSum - rSum;
                        }else if (input.charAt(i) == '+'){
                            c = lSum + rSum;
                        }else {
                            c = lSum * rSum;
                        }
                        ans.add(c);
                    }
                }
            }
        }

        if (ans.size() == 0){
            ans.add(Integer.valueOf(input));
        }
        map.put(input, ans);
        return ans;
    }
}
