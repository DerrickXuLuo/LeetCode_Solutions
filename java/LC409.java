package solution;

import java.util.HashSet;
import java.util.Set;

public class LC409 {
    public int longestPalindrome(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }

        Set<Character> set = new HashSet<>();
        int count = 0;
        for (int i = 0; i < s.length(); i++) {
            if (set.contains(s.charAt(i))) {
                set.remove(s.charAt(i));
                count++;
            } else {
                set.add(s.charAt(i));
            }
        }

        if (!set.isEmpty()) {
            return 2 * set.size() + 1;
        }

        return 0;
    }
}
