/**
 * @Author Derrick
 * @CreateTime 6/19/2020 12:01 PM
 * @Desc
 */
public class LC234 {
    public boolean isPalindrome(ListNode head) {
        if (head == null || head.next == null){
            return true;
        }

        ListNode slow = head, fast = head;
        while (fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }
        if (fast != null){
            slow = slow.next;
        }

        ListNode secondHalf = reverseLinkedList(slow);
        while (head != null && secondHalf != null){
            if (head.val != secondHalf.val){
                return false;
            }
            head = head.next;
            secondHalf = secondHalf.next;
        }

        return true;
    }

    private ListNode reverseLinkedList(ListNode head){
        ListNode prev = null, curr = head, nxt = null;

        while (curr != null){
            nxt = curr.next;
            curr.next = prev;
            prev = curr;
            curr = nxt;
        }

        return prev;
    }
}
