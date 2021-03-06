package solution;

public class LC1745 {
    public static boolean checkPartitioning(String s) {
        if (s == null || s.length() == 0) {
            return false;
        }

        //If the substring(i, j) is palindrome, then the dp[i][j] is true
        boolean[][] dp = new boolean[s.length()][s.length()];
        for (int i = 0; i < s.length(); i++) {
            for (int j = 0; j < s.length(); j++) {
                if (i >= j) {
                    dp[i][j] = true;
                }
            }
        }
        for (int l = 2; l <= s.length(); l++) {
            for (int i = 0, j = i + l - 1; j < s.length(); i++, j++) {
                if (i == j) {
                    dp[i][j] = true;
                } else {
                    dp[i][j] = (s.charAt(i) == s.charAt(j)) && dp[i + 1][j - 1];
                }
            }
        }

        for (int i = 1; i < s.length(); i++) {
            for (int j = i; j < s.length() - 1; j++) {
                if (dp[0][i - 1] && dp[i][j] && dp[j + 1][s.length() - 1]) {
                    return true;
                }
            }
        }

        return false;
    }

    public static void main(String[] args) {
        checkPartitioning("abcbdd");
    }
}
