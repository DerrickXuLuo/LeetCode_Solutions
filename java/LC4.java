class Solution {
     /**
     * Given two sorted arrays, we need to find out the median element of these two arrays.
     * Primitively, we can just combine these two sorted arrays together, which will take O(N) time.
     * Then we can get the median element in O(1) time.
     * If it is required to be completed in O(Log(m+n)) time, we should make use of binary search.
     * Let's think about a such a situation:
     * nums1 = {1, 5, 7, | 11}
     * nums2 = {3, 8, | 9, 13, 17}
     * We can somehow partition these two arrays into two segments, left half and right half.
     * When (maxLeftX <= minRightY && maxLeftY <= minRightX) is true, it means that these two arrays are partitioned correctly. The left halves can form the left half of the combining array, same as the right halves.
     * So we can get the median element using the following two methods:
     * Case1: The total number of these two arrays is ODD, median = max(maxLeftX, maxLeftY)
     * Case2: ... is EVEN, median = (max(maxLeftX, maxLeftY) + min(minRightX, minRightY)) / 2;
     *
     * Thus, the key step is to find out these two partition positions.
     * partitionX = (low + high) / 2; partitionY = (x + y + 1) / 2 - partitionX;
     * If (maxLeftX > minRightY) is true, it means that there are too many elements on the left half, the "high" should be partition - 1
     * If (maxLeftY > minRightX) is true, it means that there are too many elements on the right half, the "left" should be partition + 1
     * @param nums1
     * @param nums2
     * @return
     */
    public double findMedianSortedArrays(int[] nums1, int[] nums2){
        if (nums1.length > nums2.length){
            return findMedianSortedArrays(nums2, nums1);
        }

        int x = nums1.length, y = nums2.length;
        int low = 0, high = x;
        while (low <= high){
            int partitionX = (low + high) / 2;
            int partitionY = (x + y + 1) / 2 - partitionX;

            int maxLeftX = (partitionX == 0) ? Integer.MIN_VALUE : nums1[partitionX - 1];
            int minRightX = (partitionX == x) ? Integer.MAX_VALUE : nums1[partitionX];

            int maxLeftY = (partitionY == 0) ? Integer.MIN_VALUE : nums2[partitionY - 1];
            int minRightY = (partitionY == y) ? Integer.MAX_VALUE : nums2[partitionY];

            if (maxLeftX <= minRightY && maxLeftY <= minRightX){
                if ((x + y) % 2 == 0){
                    return ((double)Math.max(maxLeftX, maxLeftY) + Math.min(minRightX, minRightY)) / 2;
                }else {
                    return (double)Math.max(maxLeftX, maxLeftY);
                }
            }else if (maxLeftX > minRightY){
                high = partitionX - 1;
            }else {
                low = partitionX + 1;
            }
        }

        return 0.0;
    }
}
