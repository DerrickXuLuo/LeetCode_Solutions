/**
 * @Author Derrick
 * @CreateTime 6/22/2020 1:28 PM
 * @Desc
 */
public class LC263 {
    public boolean isUgly(int num) {
        for (int i = 2; i < 6 && num > 0; i++){
            while (num % i == 0){
                num /= i;
            }
        }

        return num == 1;
    }
}
