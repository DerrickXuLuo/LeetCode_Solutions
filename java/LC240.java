
/**
 * @Author Derrick
 * @CreateTime 6/19/2020 4:39 PM
 * @Desc
 */
public class LC240 {
    public boolean searchMatrix(int[][] matrix, int target) {
        if (matrix.length == 0 || matrix[0].length == 0){
            return false;
        }

        return helper(matrix, target, 0, 0, new boolean[matrix.length][matrix[0].length]);
    }

    private boolean helper(int[][] matrix, int target, int i, int j, boolean[][] visited){
        if (target == matrix[i][j]){
            return true;
        }

        visited[i][j] = true;
        boolean row = false, col = false;
        if (i + 1 < matrix.length && matrix[i + 1][j] <= target){
            row = helper(matrix, target, i + 1, j, visited);
        }
        if (j + 1 < matrix[0].length && matrix[i][j + 1] <= target){
            col = helper(matrix, target, i, j + 1, visited);
        }

        return row || col;
    }

    /**
     * Iterative solution: Start to traverse the matrix at the top right corner.
     * If the target is larger than the current element, then the target cannot be in the same row, because the elements in the same row are in ascending order.
     * If the target is less than the current element, then the target cannot be in the same column, because the elements in the same column are in ascending order.
     * Time Complexity: O(m+n)
     * @param matrix
     * @param target
     * @return
     */
    public boolean searchMatrixII(int[][] matrix, int target) {
        if (matrix.length == 0 || matrix[0].length == 0){
            return false;
        }

        int col = matrix[0].length - 1, row = 0;
        while (col >= 0 && row < matrix.length){
            if (target == matrix[row][col]){
                return true;
            }else if (target > matrix[row][col]){
                row++;
            }else{
                col--;
            }
        }

        return false;
    }
}
