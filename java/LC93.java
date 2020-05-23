public class LC93 {
    /**
     * Backtracking solution
     * @param s
     * @return
     */
    public List<String> restoreIpAddresses(String s) {
        if (s == null || s.length() < 4 || s.length() > 12){
            return new ArrayList<>();
        }

        List<String> ans = new ArrayList<>();
        helper(ans, s, 0, 0, new StringBuilder());
        return ans;
    }

    /**
     *
     * @param ans
     * @param s
     * @param num represents the number of Integers in the IP address.
     * @param pos, a pointer, indicates the current position of the string
     * @param sb
     */
    private void helper(List<String> ans, String s, int num, int pos, StringBuilder sb){
        if (pos > s.length() || num > 4){
            return;
        }else if (pos == s.length() && num == 4){
            ans.add(new String(sb.toString()));
            return;
        }

        //Because each integer is between 0 to 255, which means that each parent node may have up to three children nodes.
        for (int i = 1; i <= 3; i++){
            if (pos + i > s.length()){
                break;
            }

            int value = Integer.parseInt(s.substring(pos, pos + i));
            if (i == 1 || (i == 2 && value >= 10 && value <= 99) || (i == 3 && value >= 100 && value <= 255)){
                sb.append(value);
                if (num < 3){
                    sb.append(".");
                }

                helper(ans, s, num + 1, pos + i, sb);
                //If the num is less than 3, the last character of sb is '.', which should be deleted firstly.
                if (num < 3){
                    sb.deleteCharAt(sb.length() - 1);
                }
                //Delete the last Integer.
                sb.delete(sb.length() - i, sb.length());
            }
        }
    }
}
