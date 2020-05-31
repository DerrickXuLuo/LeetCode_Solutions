/**
 * @Author Derrick
 * @CreateTime 5/31/2020 10:07 AM
 * @Desc
 */
public class LC147 {
    public static ListNode insertionSortList(ListNode head) {
        if (head == null || head.next == null){
            return head;
        }

        //prev is the last node of the sorted list
        ListNode prev = head, curr = head.next, nxt = null;
        while (curr != null){
            if (curr.val >= prev.val){
                prev.next = curr;
                prev = curr;
                curr = curr.next;
                continue;
            }

            prev.next = null;
            nxt = curr.next;
            //The value of the current node is less than the head's, so we need to maintain a new head.
            if (curr.val < head.val){
                curr.next = head;
                head = curr;
                curr = nxt;
                continue;
            }

            ListNode subPrev = head, subCurr = head.next;
            while (subCurr != null){
                if (curr.val < subCurr.val){
                    subPrev.next = curr;
                    curr.next = subCurr;
                    break;
                }
                subPrev = subPrev.next;
                subCurr = subCurr.next;
            }
            curr = nxt;
        }

        return head;
    }

    public static void main(String[] args){
        ListNode node1 = new ListNode(3);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(4);
        ListNode node4 = new ListNode(3);
        node1.next = node2;
        node2.next = node3;
        ListNode ans = insertionSortList(node1);
    }
}
