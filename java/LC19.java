public class LC19 {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        if (head == null || head.next == null){
            return null;
        }

        ListNode dummyNode = new ListNode(0);
        dummyNode.next = head;
        Map<Integer, ListNode> map = new HashMap<>();
        map.put(0, dummyNode);

        int i = 1;
        while (head != null){
            map.put(i++, head);
            head = head.next;
        }

        ListNode pre = map.get(i - n - 1);
        ListNode nxt = map.get(i - n + 1);
        pre.next = nxt;

        return dummyNode.next;
    }

    /**
     * Two pointers solution
     * @param head
     * @param n
     * @return
     */
    public ListNode removeNthFromEndII(ListNode head, int n) {
        if (head == null || head.next == null){
            return null;
        }

        ListNode dummyNode = new ListNode(0);
        dummyNode.next = head;
        ListNode slow = dummyNode, fast = dummyNode;

        int i = 1;
        while (i <= n + 1){
            fast = fast.next;
            i++;
        }
        while (fast != null){
            slow = slow.next;
            fast = fast.next;
        }

        ListNode nxt = slow.next.next;
        slow.next = nxt;

        return dummyNode.next;
    }
}
