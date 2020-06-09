
/**
 * @Author Derrick
 * @CreateTime 6/9/2020 1:30 PM
 * @Desc Two Queues, Push takes O(1), Pop takes O(N).
 * Actually, there is another method that can save space, which is using ONE Queue to implement a stack.
 * In this method, Push takes O(N), Pop takes O(1). The implementation are methodII.
 */
public class LC225 {
    Queue<Integer> queue;
    Queue<Integer> tmpQueue;
    /** Initialize your data structure here. */
    public LC225() {
        queue = new LinkedList<>();
        tmpQueue = new LinkedList<>();
    }

    /** Push element x onto stack. */
    public void push(int x) {
        queue.offer(x);
    }

    public void pushII(int x){
        queue.offer(x);
        int size = queue.size();
        while (size > 1){
            queue.offer(queue.poll());
            size--;
        }
    }

    /** Removes the element on top of the stack and returns that element. */
    public int pop() {
        int ans = 0;
        while (queue.size() > 1){
            tmpQueue.offer(queue.poll());
        }
        ans = queue.poll();
        while (!tmpQueue.isEmpty()){
            queue.offer(tmpQueue.poll());
        }
        return ans;
    }

    public int popII(){
        return queue.poll();
    }

    /** Get the top element. */
    public int top() {
        int ans = 0;
        while (queue.size() > 1){
            tmpQueue.offer(queue.poll());
        }
        ans = queue.poll();
        tmpQueue.offer(ans);
        while (!tmpQueue.isEmpty()){
            queue.offer(tmpQueue.poll());
        }
        return ans;
    }

    public int topII(){
        return queue.peek();
    }

    /** Returns whether the stack is empty. */
    public boolean empty() {
        return queue.isEmpty();
    }
}
