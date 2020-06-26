
/**
 * @Author Derrick
 * @CreateTime 6/26/2020 11:23 AM
 * @Desc
 */
public class LC1209 {
    class Cell{
        char ch;
        int count;
        public Cell(char ch, int count){
            this.ch = ch;
            this.count = count;
        }
    }

    /**
     * Maintain a stack to memorize the number of the last character.
     * @param s
     * @param k
     * @return
     */
    public String removeDuplicates(String s, int k) {
        if (s == null || s.length() == 0 || k == 1){
            return "";
        }

        Stack<Cell> stack = new Stack<>();
        char[] chs = s.toCharArray();
        for (char ch : chs) {
            if (!stack.isEmpty() && ch == stack.peek().ch) {
                stack.peek().count++;
            } else if (stack.isEmpty() || ch != stack.peek().ch) {
                Cell cell = new Cell(ch, 1);
                stack.push(cell);
            } else {
                stack.peek().count++;
            }

            if (stack.peek().count == k) {
                stack.pop();
            }
        }

        StringBuilder sb = new StringBuilder();
        for (Cell cell : stack){
            int num = cell.count;
            while (num > 0){
                sb.append(cell.ch);
                num--;
            }
        }

        return sb.toString();
    }

    /**
     * Two pointers solution: the pointer i represents the ending position of the substring that will be returned (not included).
     * Maintain an extra array "count" to memorize the number of the corresponding duplicates.
     * @param s
     * @param k
     * @return
     */
    public String removeDuplicatesII(String s, int k) {
        int len = s.length();
        int[] count = new int[len];
        char[] chs = s.toCharArray();
        int i = 0;

        for (int j = 0; j < len; j++, i++){
            chs[i] = chs[j];
            if (i > 0 && chs[i - 1] == chs[j]){
                count[i] = count[i - 1] + 1;
                if (count[i] == k){
                    i -= k;
                }
            }else {
                count[i] = 1;
            }
        }

        return String.valueOf(chs, 0, i);
    }
}
