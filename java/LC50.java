public class LC50 {
    public double myPow(double x, int n) {
        if (n == 0){
            return 1;
        }

        if (n == 1){
            return x;
        }

        if (n < 0){
            return 1 / helper(x, -n);
        }

        return helper(x, n);
    }

    private double helper(double x, int n){
        if (n == 0){
            return 1;
        }

        double semiAns = helper(x, n / 2);
        if (n % 2 == 0){
            return semiAns * semiAns;
        }else {
            return semiAns * semiAns * semiAns;
        }
    }
}
