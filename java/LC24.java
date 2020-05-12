public class LC24 {
    public ListNode swapPairs(ListNode head) {
        if (head == null || head.next == null){
            return head;
        }

        ListNode pre = head;
        ListNode curr = head.next;

        ListNode tmp = swapPairs(head.next.next);
        curr.next = pre;
        pre.next = tmp;

        return curr;
    }
}
