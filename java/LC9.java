public class LC9 {
    public boolean isPalindrome(int x) {
        if (x < 0 || (x % 10 == 0 && x != 0)){
            return false;
        }

        int revertedNum = 0;
        while (x > revertedNum){
            revertedNum = revertedNum * 10 + x % 10;
            x /= 10;
        }

        //(x == revertedNum): the length of x is EVEN
        //(x == x == revertedNum / 10): the length of x is ODD
        return x == revertedNum || x == revertedNum / 10;
    }
}
