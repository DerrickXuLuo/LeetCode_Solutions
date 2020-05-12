public class LC21 {
    /**
     * Iterative solution
     *
     * @param l1
     * @param l2
     * @return
     */
    public ListNode mergeTwoListsI(ListNode l1, ListNode l2) {
        ListNode dummyNode = new ListNode(0);
        ListNode curr = dummyNode;

        while (l1 != null && l2 != null) {
            if (l1.val < l2.val) {
                curr.next = l1;
                l1 = l1.next;
            } else {
                curr.next = l2;
                l2 = l2.next;
            }
            curr = curr.next;
        }

        if (l1 == null) {
            curr.next = l2;
        } else {
            curr.next = l1;
        }

        return dummyNode.next;
    }

    /**
     * Recursive solution
     *
     * @param l1
     * @param l2
     * @return
     */
    public ListNode mergeTwoListsII(ListNode l1, ListNode l2) {
        if (l1 == null) {
            return l2;
        } else if (l2 == null) {
            return l1;
        } else {
            if (l1.val < l2.val) {
                l1.next = mergeTwoListsII(l1.next, l2);
                return l1;
            } else {
                l2.next = mergeTwoListsII(l1, l2.next);
                return l2;
            }
        }
    }
}
