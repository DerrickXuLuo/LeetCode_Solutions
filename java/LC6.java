public class LC6 {
    public String convert(String s, int numRows) {
        if (numRows == 1){
            return s;
        }

        List<StringBuilder> rows = new ArrayList<>();
        for (int i = 0; i < Math.min(numRows, s.length()); i++){
            rows.add(new StringBuilder());
        }

        int curRow = 0;
        boolean goingDown = false;

        for (char c : s.toCharArray()){
            rows.get(curRow).append(c);

            //Change the direction when the current row is topmost or bottommost.
            if (curRow == 0 || curRow == numRows - 1){
                goingDown = !goingDown;
            }
            //Zig-Zag order is implemented by adding or subtracting 1 here
            curRow += goingDown ? 1 : -1;
        }

        StringBuilder ret = new StringBuilder();
        for (StringBuilder row : rows){
            ret.append(row);
        }

        return ret.toString();
    }
}
