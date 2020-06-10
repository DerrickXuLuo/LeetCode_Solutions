
/**
 * @Author Derrick
 * @CreateTime 6/9/2020 3:46 PM
 * @Desc
 */
public class LC227 {
    /**
     * Solve the problem without Stack.
     * In this question, because the input String has '*' and '/' operators, we cannot simply calculate the expression from left to right.
     * Thus, in the solution, I maintained a tmpSum to record the temporary sum of the sub-expression. When there is a '*' or '/', the tmpSum will be updated.
     * When there is a '+' or '-', the tmpSum will be added to the ans.
     * Instead of using a Stack, the space complexity of this solution is CONSTANT.
     * @param s
     * @return
     */
    public static int calculate(String s) {
        if (s == null || s.length() == 0){
            return 0;
        }

        int operand = 0, ans = 0, tmpSum = 0;
        char sign = '+';

        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (Character.isDigit(ch)){
                operand = operand * 10 + (ch - '0');
            }
            if ((!Character.isDigit(ch) && ch != ' ') || i == s.length() - 1){
                if (sign == '+'){
                    ans += tmpSum;
                    tmpSum = operand;
                }else if (sign == '-'){
                    ans += tmpSum;
                    tmpSum = -operand;
                }else if (sign == '*'){
                    tmpSum *= operand;
                }else if (sign == '/'){
                    tmpSum /= operand;
                }
                sign = ch;
                operand = 0;
            }
        }

        ans += tmpSum;
        return ans;
    }

    public int calculateII(String s) {
        if (s == null || s.length() == 0){
            return 0;
        }

        int operand = 0, ans = 0;
        char sign = '+';
        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < s.length(); i++){
            char ch = s.charAt(i);
            if (Character.isDigit(ch)){
                operand = operand * 10 + (ch - '0');
            }
            if ((!Character.isDigit(ch) && ch != ' ') || i == s.length() - 1) {
                if (sign == '+') {
                    stack.push(operand);
                }
                if (sign == '-') {
                    stack.push(-operand);
                }
                if (sign == '*') {
                    stack.push(stack.pop() * operand);
                }
                if (sign == '/') {
                    stack.push(stack.pop() / operand);
                }
                sign = ch;
                operand = 0;
            }
        }

        for (int num : stack){
            ans += num;
        }

        return ans;
    }

    public static void main(String[] args){
        calculate("3+2*2");
    }
}
