/**
 * @Author Derrick
 * @CreateTime 6/1/2020 12:02 PM
 * @Desc
 */
public class LC150 {
    public static int evalRPN(String[] tokens) {
        if (tokens == null || tokens.length == 0){
            return 0;
        }

        Stack<String> stack = new Stack<>();
        stack.push(tokens[0]);

        int i = 1;
        while (!stack.isEmpty() && i < tokens.length){
            if (tokens[i].equals("+")){
                stack.push("" + (Integer.parseInt(stack.pop()) + Integer.parseInt(stack.pop())));
            }else if (tokens[i].equals("-")){
                int num1 = Integer.parseInt(stack.pop()), num2 = Integer.parseInt(stack.pop());
                stack.push("" + (num2 - num1));
            }else if (tokens[i].equals("*")){
                stack.push("" + (Integer.parseInt(stack.pop()) * Integer.parseInt(stack.pop())));
            }else if (tokens[i].equals("/")){
                int num1 = Integer.parseInt(stack.pop()), num2 = Integer.parseInt(stack.pop());
                stack.push("" + (num2 / num1));
            }else {
                stack.push(tokens[i]);
            }

            i++;
        }

        return Integer.parseInt(stack.pop());
    }

    public static void main(String[] args){
        evalRPN(new String[]{"6", "4", "/"});
    }
}
