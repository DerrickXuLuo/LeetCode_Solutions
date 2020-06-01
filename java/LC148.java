
/**
 * @Author Derrick
 * @CreateTime 5/31/2020 12:49 PM
 * @Desc
 */
public class LC148 {
    /**
     * Time = O(NLogN), Space = O(LogN)
     * @param head
     * @return
     */
    public ListNode sortList(ListNode head) {
        if (head == null || head.next == null){
            return head;
        }

        ListNode prev = null, slow = head, fast = head;

        while (fast != null && fast.next != null){
            prev = slow;
            slow = slow.next;
            fast = fast.next.next;
        }

        //Split the list
        prev.next = null;

        ListNode l1 = sortList(head);
        ListNode l2 = sortList(slow);

        return merge(l1, l2);
    }

    private ListNode merge(ListNode l1, ListNode l2){
        ListNode dummyNode = new ListNode(0), curr = dummyNode;

        while (l1 != null && l2 != null){
            if (l1.val < l2.val){
                curr.next = l1;
                l1 = l1.next;
            }else {
                curr.next = l2;
                l2 = l2.next;
            }
            curr = curr.next;
        }

        if (l1 != null){
            curr.next = l1;
        }
        if (l2 != null){
            curr.next = l2;
        }

        return dummyNode.next;
    }


    /**
     * Time = O(NLogN), Space = O(1)[constant space]
     * @param head
     * @return
     */
    public ListNode sortListII(ListNode head) {
        if (head == null || head.next == null){
            return head;
        }

        ListNode dummyNode = new ListNode(0);
        dummyNode.next = head;
        int n = 0;
        while (head != null){
            head = head.next;
            n++;
        }

        for (int step = 1; step < n; step <<= 1){
            ListNode prev = dummyNode;
            ListNode curr = dummyNode.next;
            while (curr != null){
                ListNode left = curr;
                ListNode right = split(left, step);
                curr = split(right, step);
                prev = mergeII(left, right, prev);
            }
        }

        return dummyNode.next;
    }

    private ListNode split(ListNode head, int step){
        if (head == null){
            return null;
        }

        for (int i = 1; head.next != null && i < step; i++){
            head = head.next;
        }

        ListNode right = head.next;
        head.next = null;
        return right;
    }

    private ListNode mergeII(ListNode left, ListNode right, ListNode prev){
        ListNode curr = prev;
        while (left != null && right != null){
            if (left.val < right.val){
                curr.next = left;
                left = left.next;
            }else {
                curr.next = right;
                right = right.next;
            }
            curr = curr.next;
        }

        if (left != null){
            curr.next = left;
        }else if (right != null){
            curr.next = right;
        }

        while (curr.next != null){
            curr = curr.next;
        }
        return curr;
    }

}
