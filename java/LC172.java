/**
 * @Author Derrick
 * @CreateTime 6/2/2020 5:18 PM
 * @Desc
 */
public class LC172 {
    public int trailingZeroes(int n) {
        int count = 0;
        while (n != 0){
            int tmp = n / 5;
            count += tmp;
            n = tmp;
        }

        return count;
    }
}
