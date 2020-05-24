public class LC118 {
    public List<List<Integer>> generate(int numRows) {
        if (numRows == 0){
            return new ArrayList<>();
        }

        List<List<Integer>> ans = new ArrayList<>();
        ans.add(Arrays.asList(1));

        for (int i = 1; i < numRows; i++){
            List<Integer> list = new ArrayList<>();
            List<Integer> prev = ans.get(i - 1);

            int j = -1;
            while (j < prev.size()){
                if (j == -1){
                    list.add(1);
                }else if (j == prev.size() - 1){
                    list.add(1);
                }else {
                    int num = prev.get(j) + prev.get(j + 1);
                    list.add(num);
                }
                j++;
            }

            ans.add(list);
        }

        return ans;
    }
}
