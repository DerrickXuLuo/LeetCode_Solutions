public class LC22 {
    public List<String> generateParenthesis(int n) {
        if (n <= 0){
            return new ArrayList<>();
        }

        return dfs(new ArrayList<>(), new StringBuilder(), 0, 0, n);
    }

    private List<String> dfs(List<String> ans, StringBuilder sb, int left, int right, int n){
        if (left + right == 2 * n){
            ans.add(sb.toString());
            return ans;
        }

        if (left < n){
            sb.append('(');
            dfs(ans, sb, left + 1, right, n);
            sb.deleteCharAt(sb.length() - 1);
        }

        if (right < left){
            sb.append(')');
            dfs(ans, sb, left, right + 1, n);
            sb.deleteCharAt(sb.length() - 1);
        }

        return ans;
    }
}
