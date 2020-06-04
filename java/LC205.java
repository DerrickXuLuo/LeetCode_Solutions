
/**
 * @Author Derrick
 * @CreateTime 6/3/2020 10:47 PM
 * @Desc
 */
public class LC205 {
    /**
     * HashMap solution
     *
     * @param s
     * @param t
     * @return
     */
    public boolean isIsomorphic(String s, String t) {
        if (s == null || t == null) {
            return false;
        }

        char[] sCh = s.toCharArray(), tCh = t.toCharArray();
        Map<Character, Character> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            if (map.containsKey(sCh[i])) {
                if (map.get(sCh[i]) != tCh[i]) {
                    return false;
                }
            } else {
                if (map.containsValue(tCh[i])) {
                    return false;
                } else {
                    map.put(sCh[i], tCh[i]);
                }
            }
        }

        return true;
    }

    public boolean isIsomorphicII(String s, String t) {
        if (s == null || t == null) {
            return false;
        }

        char[] sCh = s.toCharArray(), tCh = t.toCharArray();
        int[] arrS = new int[128], arrT = new int[128];
        for (int i = 0; i < s.length(); i++) {
            if (arrS[sCh[i]] != arrT[tCh[i]]) {
                return false;
            }
            arrS[sCh[i]] = i + 1;
            arrT[tCh[i]] = i + 1;
        }

        return true;
    }
}
