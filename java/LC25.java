public class LC25 {
    public ListNode reverseKGroup(ListNode head, int k) {
        if (head == null || head.next == null){
            return head;
        }

        int count = 0;
        ListNode curr = head;
        while (curr != null && count < k){
            curr = curr.next;
            count++;
        }

        //The number of the nodes in the sublist is enough
        if (count == k){
            curr = reverseKGroup(curr, k);

            while (count-- > 0){
                ListNode tmp = head.next;
                head.next = curr;
                curr = head;
                head = tmp;
            }
            head = curr;
        }

        return head;
    }
}
