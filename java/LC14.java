public class LC14 {
    public static String longestCommonPrefix(String[] strs) {
        if (strs == null || strs.length == 0){
            return "";
        }else if (strs.length == 1){
            return strs[0];
        }

        int i = 0;
        loop : while (true){
            for (int j = 0; j < strs.length - 1; j++){
                if (i < strs[j].length() && i < strs[j + 1].length()
                        && strs[j].charAt(i) == strs[j + 1].charAt(i)){
                    continue;
                }else {
                    break loop;
                }
            }
            i++;
        }

        return strs[0].substring(0, i);
    }
}
