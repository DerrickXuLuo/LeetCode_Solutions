/**
 * @Author Derrick
 * @CreateTime 6/2/2020 2:21 PM
 * @Desc Actually, it is a 26-format problem,
 * which means that we need to add ONE when the number meets 26 or the multiples of 26.
 */
public class LC168 {
    public static String convertToTitle(int n) {
        StringBuilder ans = new StringBuilder();

        while (n > 0){
            n--;
            ans.insert(0, (char)('A' + n % 26));
            n /= 26;
        }

        return ans.toString();
    }

    public static void main(String[] args){
        convertToTitle(702);
    }

}
