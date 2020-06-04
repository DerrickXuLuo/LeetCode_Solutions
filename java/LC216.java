
/**
 * @Author Derrick
 * @CreateTime 6/4/2020 5:17 PM
 * @Desc
 */
public class LC216 {
    public static List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> ans = new ArrayList<>();
        for (int i = 1; i <= 9 - k + 1; i++){
            List<Integer> list = new ArrayList<>();
            list.add(i);
            dfs(ans, k, n, 1, i, i + 1, list);
        }
        return ans;
    }

    private static void dfs(List<List<Integer>> ans, int k, int n, int count, int sum, int num, List<Integer> list){
        if (count == k && sum == n){
            ans.add(new ArrayList<>(list));
            return;
        }else if (count > k){
            return;
        }

        for (int i = num; i <= 9; i++){
            if (sum + i <= n){
                list.add(i);
                dfs(ans, k, n, count + 1, sum + i, i + 1, list);
                list.remove(list.size() - 1);
            }else {
                break;
            }
        }
    }

    public static void main(String[] args){
        combinationSum3(3, 7);

    }
}
