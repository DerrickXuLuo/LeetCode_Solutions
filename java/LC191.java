
/**
 * @Author Derrick
 * @CreateTime 6/3/2020 10:41 AM
 * @Desc
 */
public class LC191 {
    // you need to treat n as an unsigned value

    /**
     * Loop and Flip
     * @param n
     * @return
     */
    public static int hammingWeight(int n) {
        int index = 1;
        int count = 0;
        for (int i = 0; i < 32; i++){
            if ((index & n) != 0){
                count++;
            }
            index = (index << 1);
        }

        return count;
    }

    /**
     * Bit manipulation trick: repeatedly flip the least-significant 1-bit of the number to 0,
     * and add 1 to the sum. As soon as the number becomes 0, we know that it does not have any more 1-bits, then we can return the sum.
     * Key idea: doing a bit-wise AND of n and n-1 flips the least-significant 1-bit in n to 0.
     * @param n
     * @return
     */
    public static int hammingWeightII(int n) {
        int count = 0;
        while (n != 0){
            count++;
            n &= (n - 1);
        }

        return count;
    }

    public static void main(String[] args){
        hammingWeight(-3);
    }
}
