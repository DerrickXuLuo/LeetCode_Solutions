public class LC75 {
    /**
     * Two-pass solution
     * @param nums
     */
    public static void sortColors(int[] nums) {
        if (nums == null || nums.length == 0){
            return;
        }

        int[] count = new int[3];
        for (int num : nums){
            count[num]++;
        }

        int i = 0;
        while (i < nums.length){
            for (int j = 0; j < count.length; j++){
                while (count[j] > 0){
                    nums[i++] = j;
                    count[j]--;
                }
            }
        }
    }

    /**
     * One-pass solution
     * @param nums
     */
    public static void sortColorsII(int[] nums) {
        if (nums == null || nums.length == 0){
            return;
        }

        int s = 0, e = nums.length - 1, index = 0;
        while (index <= e){
            if (nums[index] == 0){
                nums[index] = nums[s];
                nums[s] = 0;
                s++;
            }
            if (nums[index] == 2){
                nums[index] = nums[e];
                nums[e] = 2;
                e--;
                index--;
            }
            index++;
        }
    }


    public static void main(String[] args){
        sortColors(new int[]{2,0,2,1,1,0});
    }
}
