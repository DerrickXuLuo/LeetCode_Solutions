public class LC36 {
    public boolean isValidSudoku(char[][] board) {
        //Each row represents a row, each column represents the existence of the corresponding element.
        boolean[][] row = new boolean[9][9];
        //Each row represents a column, each column represents the existence of the corresponding element.
        boolean[][] col = new boolean[9][9];
        //Each row represents a sub-box, each column represents the existence of the corresponding element.
        boolean[][] subCube = new boolean[9][9];

        for (int i = 0; i < board.length; i++){
            for (int j = 0; j < board[0].length; j++){
                if (board[i][j] != '.'){
                    int val = board[i][j] - '1';
                    if (row[i][val] || col[j][val] || subCube[3 * (i / 3) + j / 3][val]){
                        return false;
                    }
                    row[i][val] = col[j][val] = subCube[3 * (i / 3) + j / 3][val] = true;
                }
            }
        }

        return true;
    }
}
