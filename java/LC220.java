
/**
 * @Author Derrick
 * @CreateTime 6/5/2020 11:59 AM
 * @Desc
 */
public class LC220 {
    /**
     * Use the idea from bucket sort, so the time complexity is O(N).
     * @param nums
     * @param k
     * @param t
     * @return
     */
    public static boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
        if (k < 1 || t < 0){
            return false;
        }

        Map<Long, Long> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++){
            long remappedNum = (long)nums[i] - Integer.MIN_VALUE;
            long bucket = remappedNum / ((long)t + 1);

            /*
            The differences of values of elements in each bucket are at most t,
            OR the differences of values of elements in adjacent buckets might be at most t.
            */
            if (map.containsKey(bucket)
                || (map.containsKey(bucket - 1) && remappedNum - map.get(bucket - 1) <= t)
                    || (map.containsKey(bucket + 1) && map.get(bucket + 1) - remappedNum <= t)){
                return true;
            }

            /*
            Limit the size of the map to k, cause the difference of distance between two selected elements should be at most k.
            If the size is larger than k, we need to remove the leftmost element so that the distance between leftmost element and rightmost element is still at most k.
            */
            if (map.entrySet().size() >= k){
                long leftMostBucket = ((long)nums[i - k] - Integer.MIN_VALUE) / ((long)t + 1);
                map.remove(leftMostBucket);
            }
            map.put(bucket, remappedNum);
        }

        return false;
    }

    public static void main(String[] args){
        containsNearbyAlmostDuplicate(new int[]{1, 2, 3, 1}, 1, 1);
    }
}
