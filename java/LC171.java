
/**
 * @Author Derrick
 * @CreateTime 6/2/2020 4:44 PM
 * @Desc
 */
public class LC171 {
    public static int titleToNumber(String s) {
        char[] chs = s.toCharArray();
        int num = 0;
        for (int i = 0; i < chs.length; i++) {
            int tmp = chs[i] - 'A' + 1;
            if (i < chs.length - 1) {
                int j = i;
                while (j < chs.length - 1) {
                    tmp *= 26;
                    j++;
                }
            }
            num += tmp;
        }

        return num;
    }

    public static void main(String[] args){
        titleToNumber("AAA");
    }
}
