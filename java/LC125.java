package solution;

public class LC125 {
    public static boolean isPalindrome(String s) {
        if (s == null || s.length() == 0) {
            return true;
        }

        int head = 0;
        int tail = s.length() - 1;

        while (head < tail) {
            if (head < s.length() && !Character.isLetterOrDigit(s.charAt(head))){
                head++;
            } else if (tail >= 0 && !Character.isLetterOrDigit(s.charAt(tail))) {
                tail--;
            } else if (Character.toLowerCase(s.charAt(head)) == Character.toLowerCase(s.charAt(tail))) {
                head++;
                tail--;
            } else {
                return false;
            }
        }

        return true;
    }

    public static void main(String[] args) {
        isPalindrome(".,");
    }
}
