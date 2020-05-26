public class LC131 {
    public List<List<String>> partition(String s) {
        if (s == null || s.length() == 0){
            return new ArrayList<>();
        }

        List<List<String>> ans = new ArrayList<>();
        dfs(s, 0, new ArrayList<>(), ans);

        return ans;
    }

    private void dfs(String s, int pos, List<String> list, List<List<String>> ans){
        if (pos == s.length()){
            ans.add(new ArrayList<>(list));
        }else {
            for (int i = pos; i < s.length(); i++){
                if (isPal(s, pos, i)){
                    list.add(s.substring(pos, i + 1));
                    dfs(s, i + 1, list, ans);
                    list.remove(list.size() - 1);
                }
            }
        }
    }

    private boolean isPal(String s, int low, int high){
        while (low < high){
            if (s.charAt(low++) != s.charAt(high--)){
                return false;
            }
        }
        return true;
    }

    /**
     * DFS + memo
     * @param s
     * @return
     */
    public List<List<String>> partitionII(String s) {
        if (s == null || s.length() == 0){
            return new ArrayList<>();
        }

        char[] chs = s.toCharArray();
        List<List<String>> ans = new ArrayList<>();
        boolean[][] dp = new boolean[s.length()][s.length()];
        for (int i = 0; i < s.length(); i++){
            for (int j = 0; j <= i; j++){
                if (chs[i] == chs[j] && ((i - j <= 2) || dp[j + 1][i - 1])){
                    dp[j][i] = true;
                }
            }
        }

        dfsII(dp, s, 0, new ArrayList<>(), ans);
        return ans;
    }

    private void dfsII(boolean[][] dp, String s, int pos, List<String> list, List<List<String>> ans){
        if (pos == s.length()){
            ans.add(new ArrayList<>(list));
        }else {
            for (int i = pos; i < s.length(); i++){
                if (dp[pos][i]){
                    list.add(s.substring(pos, i + 1));
                    dfsII(dp, s, i + 1, list, ans);
                    list.remove(list.size() - 1);
                }
            }
        }
    }
}
