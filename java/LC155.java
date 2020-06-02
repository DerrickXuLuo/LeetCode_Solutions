/**
 * @Author Derrick
 * @CreateTime 6/1/2020 5:29 PM
 * @Desc
 */
public class LC155 {
    /**
     * Two stacks solution: The "stack" stores the input values in order, the "minStack" stores the updated minimum values.
     */
    /** initialize your data structure here. */
    Stack<Integer> minStack;
    Stack<Integer> stack;
    public LC155() {
        minStack = new Stack<>();
        stack = new Stack<>();
    }

    public void push(int x) {
        stack.push(x);
        if (!minStack.isEmpty() && minStack.peek() >= x){
            minStack.push(x);
        }else if (minStack.isEmpty()){
            minStack.push(x);
        }
    }

    public void pop() {
        int popNum = stack.pop();
        if (popNum == minStack.peek()){
            minStack.pop();
        }
    }

    public int top() {
        return stack.peek();
    }

    public int getMin() {
        return minStack.peek();
    }

    /**
     * One stack solution
     */
    int min = Integer.MAX_VALUE;
    public void pushII(int x){
        if (x <= min){
            stack.push(min);
            min = x;
        }
        stack.push(x);
    }

    public void popII(){
        if (stack.pop() == min){
            min = stack.pop();
        }
    }

    public int getMinII(){
        return min;
    }

}
