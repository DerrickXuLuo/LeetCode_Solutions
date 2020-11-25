class Solution {
    public int getDecimalValue(ListNode head) {
        int sum = 0;
        while (head != null) {
            if (sum == 0) {
                sum = head.val;
                head = head.next;
            } else {
                sum = (sum << 1) + head.val;
                head = head.next;
            }
        }
        
        return sum;
    }
}
