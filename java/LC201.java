
/**
 * @Author Derrick
 * @CreateTime 6/3/2020 12:07 PM
 * @Desc
 */
public class LC201 {
    /**
     * TLE
     * @param m
     * @param n
     * @return
     */
    public int rangeBitwiseAnd(int m, int n) {
        if (m == 0){
            return 0;
        }

        for (int i = m; i <= n; i++){
            m &= i;
        }

        return m;
    }

    /**
     * Time Complexity: Worst case is O(Log32)
     * @param m
     * @param n
     * @return
     */
    public static int rangeBitwiseAndII(int m, int n) {
        if (m == 0){
            return 0;
        }

        int moveFactor = 1;
        while (m != n){
            //(m >>= 1) equals to m/2, so we maintain a moveFactor to memorize the times of right shift
            m >>= 1;
            n >>= 1;
            moveFactor <<= 1;
        }

        return m * moveFactor;
    }

    public static void main(String[] args){
        rangeBitwiseAndII(4, 32);
    }
}
