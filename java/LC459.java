public class LC459 {
    public static boolean repeatedSubstringPattern(String str) {
        //Build a new string with copying the original string twice.
        //But we need to eliminate the first and last character of the new string.
        //By doing this step, we can avoid the situation that the new string always contain the original string.
        String strCopy = str.substring(1, str.length()) + str.substring(0, str.length() - 1);
        if (checkContainsKMP(str, strCopy)){
            return true;
        }

        return false;
    }

    private static boolean checkContainsKMP(String pat, String txt){
        int[] lps = computeLPS(pat);
        //j for pat, i for txt
        int j = 0, i = 0;

        char[] patChar = pat.toCharArray(), txtChar = txt.toCharArray();
        while (i < txt.length()){
            if (patChar[j] == txtChar[i]){
                j++;
                i++;
            }

            if (j == pat.length()){
                return true;
            }else if (i < txt.length() && patChar[j] != txtChar[i]){
                if (j != 0){
                    j = lps[j - 1];
                }else {
                    i++;
                }
            }
        }

        return false;
    }

    private static int[] computeLPS(String pat){
        int[] lps = new int[pat.length()];
        lps[0] = 0;
        int j = 0, i = 1;

        char[] chs = pat.toCharArray();
        while (i < pat.length()){
            if (chs[j] == chs[i]){
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

    public static void main(String[] args){
        if (repeatedSubstringPattern("aba")){
            System.out.println("True");
        }else {
            System.out.println("False");
        }
    }
}
