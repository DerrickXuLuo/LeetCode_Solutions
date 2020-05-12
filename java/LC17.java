public class LC17 {
    public List<String> letterCombinations(String digits) {
        if (digits == null || digits.length() == 0){
            return new ArrayList<>();
        }

        Map<Character, String> map = new HashMap<>();
        map.put('2', "abc");
        map.put('3', "def");
        map.put('4', "ghi");
        map.put('5', "jkl");
        map.put('6', "mno");
        map.put('7', "pqrs");
        map.put('8', "tuv");
        map.put('9', "wxyz");

        return helper(new ArrayList<>(), new StringBuilder(), map, digits, 0);
    }

    private List<String> helper(List<String> list, StringBuilder sb, Map<Character, String> map, String digits, int pos){
        if (pos == digits.length()){
            list.add(new String(sb));
            return list;
        }else{
            String letters = map.get(digits.charAt(pos));

            for (int i = 0; i < letters.length(); i++){
                sb.append(letters.charAt(i));
                helper(list, sb, map, digits, pos + 1);
                sb.deleteCharAt(sb.length() - 1);
            }
        }

        return list;
    }
}
