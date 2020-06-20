
/**
 * @Author Derrick
 * @CreateTime 6/19/2020 7:28 PM
 * @Desc
 */
public class LC242 {
    public boolean isAnagram(String s, String t) {
        if (s.equals(t)){
            return true;
        }
        if (s.length() != t.length()){
            return false;
        }

        int[] sArr = new int[26];
        for (char ch : s.toCharArray()){
            sArr[ch - 'a']++;
        }

        for (char ch : t.toCharArray()){
            sArr[ch - 'a']--;
        }

        for (int num : sArr){
            if (num != 0){
                return false;
            }
        }
        return true;
    }
}
