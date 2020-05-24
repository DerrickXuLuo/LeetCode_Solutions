public class LC120 {
    /**
     * DP solution
     * @param triangle
     * @return
     */
    public int minimumTotal(List<List<Integer>> triangle) {
        if (triangle == null || triangle.size() == 0){
            return 0;
        }

        int[] arr = new int[triangle.size() + 1];
        for (int i = triangle.size() - 1; i >= 0; i--){
            for (int j = 0; j < triangle.get(i).size(); j++){
                arr[j] = Math.min(arr[j], arr[j + 1]) + triangle.get(i).get(j);
            }
        }

        return arr[0];
    }

    /**
     * DFS: TLE. If we need to use DFS, we need to use DFS with memorization.
     * But it will take extra space which is at least the same size as the input triangle.
     * @param triangle
     * @return
     */
    public int minimumTotalII(List<List<Integer>> triangle) {
        if (triangle == null || triangle.size() == 0){
            return 0;
        }

        return helper(triangle, 0, 1, triangle.get(0).get(0));
    }

    int ans = Integer.MAX_VALUE;
    private int helper(List<List<Integer>> triangle, int pos, int level, int pathSum){
        if (level == triangle.size()){
            return pathSum;
        }

        for (int i = 0; i < 2; i++){
            ans = Math.min(ans, helper(triangle, pos + i, level + 1, pathSum + triangle.get(level).get(pos + i)));
        }

        return ans;
    }
}
