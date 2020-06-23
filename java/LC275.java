/**
 * @Author Derrick
 * @CreateTime 6/23/2020 11:14 AM
 * @Desc
 */
public class LC275 {
    public static int hIndex(int[] citations) {
        if (citations == null || citations.length == 0){
            return 0;
        }

        int len = citations.length;
        int i = 0, j = citations.length - 1;
        while (i < j){
            int m = i + (j - i) / 2;

            if (citations[m] < (len - m)){
                i = m + 1;
            }else {
                j = m;
            }
        }

        if (i < len && citations[i] >= len - i){
            return len - i;
        }else {
            return 0;
        }
    }

    public static void main(String[] args){
        hIndex(new int[]{0,1,2,5,6});
    }
}
