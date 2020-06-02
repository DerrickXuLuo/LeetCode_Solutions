/**
 * @Author Derrick
 * @CreateTime 6/1/2020 8:00 PM
 * @Desc
 */
public class LC160 {
    /**
     * HashTable solution: Time = O(m+n), Space O(m or n)
     *
     * @param headA
     * @param headB
     * @return
     */
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if (headA == null || headB == null) {
            return null;
        }

        Set<ListNode> set = new HashSet<>();
        while (headA != null) {
            set.add(headA);
            headA = headA.next;
        }

        while (headB != null) {
            if (set.contains(headB)) {
                return headB;
            }
            headB = headB.next;
        }

        return null;
    }

    /**
     * Two pointers solution: Space = O(1)
     * @param headA
     * @param headB
     * @return
     */
    public ListNode getIntersectionNodeII(ListNode headA, ListNode headB) {
        if (headA == null || headB == null) {
            return null;
        }

        ListNode pA = headA, pB = headB;
        while (pA != pB) {
            if (pA == null) {
                pA = headB;
            } else if (pB == null) {
                pB = headA;
            }else {
                pA = pA.next;
                pB = pB.next;
            }
        }

        return pA;
    }
}
