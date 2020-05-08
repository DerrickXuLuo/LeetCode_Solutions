public class LC7 {
    public int reverse(int x) {
        int res = 0;
        while (x != 0){
            int pop = x % 10;
            x /= 10;

            //There are two corner cases, which are the "res" is very close to MAX_VALUE or the MIN_VALUE.
            if (res > (Integer.MAX_VALUE / 10) || (res == Integer.MAX_VALUE / 10 && pop > 7)){ //The reason using pop>7 here is that MAX_VALUE=2147483647
                return 0;
            }else if (res < (Integer.MIN_VALUE / 10) || (res == Integer.MIN_VALUE / 10 && pop < -8)){ ////The reason using pop<-8 here is that MIN_VALUE=-2147483648
                return 0;
            }else {
                res = res * 10 + pop;
            }
        }

        return res;
    }
}
