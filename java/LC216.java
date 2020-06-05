
/**
 * @Author Derrick
 * @CreateTime 6/4/2020 5:17 PM
 * @Desc
 */
public class LC216 {
    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> ans = new ArrayList<>();
        dfs(ans, new ArrayList<>(), k, n, 1);
        return ans;
    }

    /**
     * Time Complexity: Less than O(C(k, 9))
     * @param ans
     * @param list
     * @param k
     * @param n
     * @param start
     */
    private void dfs(List<List<Integer>> ans, List<Integer> list, int k, int n, int start){
        if (k == list.size() && n == 0){
            ans.add(new ArrayList<>(list));
            return;
        }else if (k < list.size()) {
            return;
        }

        for (int i = start; i <= n && i <= 9; i++){
            list.add(i);
            dfs(ans, list, k, n - i, i + 1);
            list.remove(list.size() - 1);
        }
    }

    public static void main(String[] args){
//        combinationSum3(3, 7);
    }
}
