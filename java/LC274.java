/**
 * @Author Derrick
 * @CreateTime 6/22/2020 11:04 PM
 * @Desc
 */
public class LC274 {
    /**
     * Sort the array in descending order firstly, then find the last number which is not less than its index.
     * Time Complexity: O(NLogN)
     * @param citations
     * @return
     */
    public int hIndex(int[] citations) {
        if (citations == null || citations.length == 0) {
            return 0;
        }

        Integer[] arr = new Integer[citations.length];
        for (int i = 0; i < citations.length; i++) {
            arr[i] = citations[i];
        }

        Arrays.sort(arr, Collections.reverseOrder());
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] < i + 1) {
                return i + 1;
            }
        }

        return citations.length;
    }

    /**
     * O(N) solution
     * @param citations
     * @return
     */
    public int hIndexII(int[] citations) {
        if (citations == null || citations.length == 0) {
            return 0;
        }

        int[] count = new int[citations.length + 1];
        for (int num : citations) {
            if (num > citations.length) {
                count[citations.length]++;
            } else {
                count[num]++;
            }
        }

        for (int i = citations.length; i >= 0; i--) {
            if (count[i] >= i) {
                return i;
            }
        }
        return 0;
    }
}
