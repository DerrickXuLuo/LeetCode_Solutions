/**
 * @Author Derrick
 * @CreateTime 6/3/2020 2:23 PM
 * @Desc
 */
public class LC203 {
    /**
     * Iterative solution
     * @param head
     * @param val
     * @return
     */
    public ListNode removeElements(ListNode head, int val) {
        if (head == null){
            return null;
        }

        ListNode dummyNode = new ListNode(0);
        dummyNode.next = head;
        ListNode prev = dummyNode;

        while (head != null){
            if (head.val == val) {
                prev.next = head.next;
            }else {
                prev = head;
            }
            head = head.next;
        }

        return dummyNode.next;
    }

    /**
     * Recursive way:
     * @param head
     * @param val
     * @return
     */
    public ListNode removeElementsII(ListNode head, int val) {
        if (head == null){
            return null;
        }

        ListNode nxt = removeElementsII(head.next, val);
        if (head.val == val){
            return nxt;
        }
        head.next = nxt;
        return head;
    }
}
