public class Solution {
    /**
     * Using the method that expand from the center will take O(n^2) time.
     * @param s
     * @return
     */
    public String longestPalindrome(String s) {
        if (s == null || s.length() == 0){
            return "";
        }

        int st = 0, end = 0;
        for (int i = 0; i < s.length(); i++){
            //Odd length
            int lenOdd = expandCenter(s, i, i);
            //Even length
            int lenEven = expandCenter(s, i, i + 1);

            int len = Math.max(lenOdd, lenEven);
            if (len > end - st + 1) {
                st = i - (len - 1) / 2;
                end = i + len / 2;
            }
        }

        return s.substring(st, end + 1);
    }

    /**
     * Expand the substring from the center.
     * The center will be a single element or a pair of elements.
     * @param s
     * @param l
     * @param r
     * @return
     */
    private int expandCenter(String s, int l, int r){
        char[] chs = s.toCharArray();
        while (l >= 0 && r < s.length() && chs[l] == chs[r]){
            l--;
            r++;
        }
        
        return r - l - 1;
    }
}
