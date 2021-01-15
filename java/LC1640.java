  public class LC1640 {
    public boolean canFormArray(int[] arr, int[][] pieces) {
        Map<Integer, int[]> map = new HashMap<>();
        for (int[] piece : pieces) {
            map.put(piece[0], piece);
        }

        int i = 0;
        while (i < arr.length) {
            if (map.containsKey(arr[i])) {
                int[] tmpArr = map.get(arr[i]);
                for (int num : tmpArr) {
                    if (arr[i] != num) {
                        return false;
                    }
                    i++;
                }
            } else {
                return false;
            }
        }

        return true;
    }
}
