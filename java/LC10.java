public class LC10 {
    enum Result{
        TRUE, FALSE
    }
    Result[][] memo;

    /**
     * DFS with memorization
     * Time Complexity = O(m*n); Space Complexity = O(m*n)
     * @param s
     * @param p
     * @return
     */
    public boolean isMatchOptimal(String s, String p) {
        memo = new Result[s.length() + 1][p.length() + 1];
        return dp(0, 0, s, p);
    }

    private boolean dp(int i, int j, String s, String p){
        if (memo[i][j] != null){
            return memo[i][j] == Result.TRUE;
        }

        boolean res;
        if (j == p.length()){
            res = i == s.length();
        }else {
            boolean firstMatch = (i < s.length() && (p.charAt(j) == s.charAt(i) || p.charAt(j) == '.'));

            if (j + 1 < p.length() && p.charAt(j + 1) == '*'){
                res = (dp(i, j + 2, s, p) ||
                        (firstMatch && dp(i + 1, j, s, p)));
            }else {
                res = firstMatch && dp(i + 1, j + 1, s, p);
            }
        }
        memo[i][j] = res ? Result.TRUE : Result.FALSE;

        return res;
    }


    /**
     * Primitive solution: DFS without memorization
     * @param s
     * @param p
     * @return
     */
    public boolean isMatch(String s, String p) {
        if (p.length() == 0){
            return s.length() == 0;
        }

        //For the first characters in s and p, if they are both letters, or the character in the p is '.', firstMatch will be true
        boolean firstMatch = (!s.isEmpty() &&
                (p.charAt(0) == s.charAt(0) || p.charAt(0) == '.'));

        //Let's think about a case like this: s = "xx-----", p = "x*-----"
        //So for such a case, we need to consider two situations:
        //1. "*" represents zero of preceding element.
        //2. "*" represents preceding element at least one time.
        if (p.length() >= 2 && p.charAt(1) == '*'){
            return (isMatch(s, p.substring(2)) ||
                    firstMatch && isMatch(s.substring(1), p));
        }else {
            //The second element is not "*" in the p, we can just simply check whether the letters at the same position is identical or not.
            return firstMatch && isMatch(s.substring(1), p.substring(1));
        }
    }
}
