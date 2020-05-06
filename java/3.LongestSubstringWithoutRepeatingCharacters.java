class Solution {
    /**
     * One pass solution: Maintain a hashmap, key is the character,
     * value is the corresponding position.
     * @param s
     * @return
     */
    public int lengthOfLongestSubstring(String s) {
        if (s == null || s.length() == 0){
            return 0;
        }

        int len = s.length(), maxLen = 0;
        Map<Character, Integer> map = new HashMap<>();

        for (int j = 0, i = 0; j < len; j++){
            if (map.containsKey(s.charAt(j))) {
                i = Math.max(map.get(s.charAt(j)), i);
            }
            maxLen = Math.max(maxLen, j - i + 1);
            
            //The value should be (position + 1)
            //Because when there is repeating element existing afterwards,
            //the current element should be abandoned.
            map.put(s.charAt(j), j + 1);
        }

        return maxLen;
    }
}
