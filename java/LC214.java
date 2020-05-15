public class LC214 {
    public String shortestPalindrome(String s) {
        if (s == null || s.length() == 0){
            return "";
        }

        String tmpStr = s + "#" + new StringBuilder(s).reverse().toString();

        int[] lps = computeLPS(tmpStr);

        return new StringBuilder(s).reverse().toString().substring(0, s.length() - lps[lps.length - 1]) + s;
    }

    private int[] computeLPS(String str){
        int[] lps = new int[str.length()];
        lps[0] = 0;
        int j = 0, i = 1;

        char[] chs = str.toCharArray();
        while (i < str.length()){
            if (chs[i] == chs[j]){
                lps[i] = j + 1;
                j++;
                i++;
            }else {
                if (j != 0){
                    j = lps[j - 1];
                }else {
                    lps[i] = 0;
                    i++;
                }
            }
        }

        return lps;
    }
}
