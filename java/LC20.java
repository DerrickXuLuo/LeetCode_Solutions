public class LC20 {
    public boolean isValid(String s) {
        if (s == null || s.length() == 0){
            return true;
        }

        Stack<Character> stack = new Stack<>();
        char[] chs = s.toCharArray();

        for (char ch : chs){
            if (ch == '(' || ch == '[' || ch == '{'){
                stack.push(ch);
            }else if (ch == ')'){
                if (!stack.isEmpty() && stack.peek() == '('){
                    stack.pop();
                }else {
                    return false;
                }
            }else if (ch == ']'){
                if (!stack.isEmpty() && stack.peek() == '['){
                    stack.pop();
                }else {
                    return false;
                }
            }else if (ch == '}'){
                if (!stack.isEmpty() && stack.peek() == '{'){
                    stack.pop();
                }else {
                    return false;
                }
            }
        }

        return stack.isEmpty();
    }
}
