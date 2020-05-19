public class LC48 {
    public void rotate(int[][] matrix) {
        if (matrix == null || matrix.length == 0){
            return;
        }

        //Reverse up to down
        int N = matrix.length;
        for (int i = 0; i < N / 2; i++){
            int[] tmp = matrix[i];
            matrix[i] = matrix[N - 1 - i];
            matrix[N - 1 - i] = tmp;
        }

        //Swap symmetrically
        for (int i = 0; i < N; i++){
            for (int j = i + 1; j < N; j++){
                int tmp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = tmp;
            }
        }
    }
}
