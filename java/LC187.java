
/**
 * @Author Derrick
 * @CreateTime 6/2/2020 7:53 PM
 * @Desc
 */
public class LC187 {
    /**
     * HashSet solution:
     * Time Complexity: 1. for loop takes O(N). 2. substring() takes O(N)
     * Thus, the overall time complexity is O(n^2).
     * Space Complexity: O(N)
     * @param s
     * @return
     */
    public List<String> findRepeatedDnaSequences(String s) {
        if (s == null || s.length() <= 10){
            return new ArrayList<>();
        }

        Set<String> set = new HashSet<>(), ans = new HashSet<>();
        for (int i = 0; i < s.length() - 9; i++){
            String subStr = s.substring(i, i + 10);
            if (set.contains(subStr)){
                ans.add(subStr);
            }else {
                set.add(subStr);
            }
        }

        return new ArrayList<>(ans);
    }

    /**
     * Bit operation: It can save space by using 20-bits to represent a 10-letter-long sequences.
     * @param s
     * @return
     */
    public List<String> findRepeatedDnaSequencesII(String s) {
        Set<Integer> words = new HashSet<>();
        Set<String> ans = new HashSet<>();
        char[] map = new char[26];
        /*Maintains two bits to represents a letter,
        * which means that a 10-letter-long sequences can be represented as a Integer(32-bits).*/
//        map['A' - 'A'] = 0;
        map['C' - 'A'] = 1;
        map['G' - 'A'] = 2;
        map['T' - 'A'] = 3;

        for (int i = 0; i < s.length(); i++){
            int v = 0;
            for (int j = i; j < i + 10; j++){
                //Left shift two bits since two bits represent a letter.
                v <<= 2;
                v |= map[s.charAt(j) - 'A'];
            }

            //If the v can be added into set "words", it means that v occurs firstly.
            if (!words.add(v)){
                ans.add(s.substring(i, i + 10));
            }
        }

        return new ArrayList<>(ans);
    }
}
