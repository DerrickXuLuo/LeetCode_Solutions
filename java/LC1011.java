package leetcode;

/**
 * @Author XuLuo
 * @Description
 * @Date 2020/11/23 4:12 PM
 **/
public class LC1011 {
    public static int shipWithinDays(int[] weights, int D) {
        int maxWeight = Integer.MIN_VALUE, sum = 0;
        for (int weight : weights) {
            sum += weight;
            maxWeight = Math.max(maxWeight, weight);
        }

        // The left bound is tha maximum element of the weights array, cause the least capacity of a ship should be larger than the bag with the maximum weight in the array.
        int left = maxWeight, right = sum;
        while (left < right) {
            int m = left + (right - left) / 2;

            int tmpSum = 0, d = 1;
            for (int i = 0; i < weights.length; i++) {
                if (tmpSum + weights[i] > m) {
                    tmpSum = 0;
                    d++;
                }
                tmpSum += weights[i];
            }

            if (d > D) {
                left = m + 1;
            } else {
                right = m;
            }
        }

        return left;
    }

    public static void main(String[] args) {
        shipWithinDays(new int[]{1,2,3,4,5,6,7,8,9,10}, 5);
    }
}
