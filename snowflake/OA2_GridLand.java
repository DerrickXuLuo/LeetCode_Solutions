package com.company.review.algorithms;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @Author Derrick
 * @CreateTime 6/27/2020 10:06 AM
 * @Desc
 */
public class GridLand {
    static class Cell{
        int x;
        int y;
        public Cell(int x, int y){
            this.x = x;
            this.y = y;
        }
    }

    static List<String> ans;
    static int count;
    
    /**
     * Main idea: we can simply solve this problem by modifying the String consisting of "H" and "V".
     * According to the description, an inhabitant can move horizontally or vertically to an adjacent cell, and the path
     * between the origin and the destination should be minimum. So an inhabitant can only move to the right cell or down cell.
     * In this case, the path will be a combination of specific numbers of "H" and "V". We just need to swap the "H" and "V" in the String
     * then we can get the specific path which follows the alphabetical order.
     * For example, if the journey is "2 2 1", the return string should be "HVHV" which is obtained by swap the second "H" and "V"
     * in the initial path "HHVV".
     * @param journeys
     * @return
     */
    public static List<String> getSafePathsII(List<String> journeys) {
        // Write your code here
        ans = new ArrayList<>();
        for (String journey : journeys){
            String[] strings = journey.split(" ");
            int x = Integer.parseInt(strings[0]), y = Integer.parseInt(strings[1]);
            StringBuilder sb = new StringBuilder();
            //Build the initial String consisting of "H" and "V"
            for (int i = 0; i < x; i++){
                sb.append("H");
            }
            for (int j = 0; j < y; j++){
                sb.append("V");
            }
            ans.add(getAns(sb, Integer.parseInt(strings[2]), x, y));
        }

        return ans;
    }

    private static String getAns(StringBuilder sb, int index, int hNum, int vNum){
        if (index == 0){
            return sb.toString();
        }

        int section = index / vNum;
        int mod = index % vNum;

        for (int i = 0; i < section; i++){
            sb = swap(sb, hNum - 1 - i, sb.length() - 1 - i);
        }
        sb = swap(sb, hNum - 1 - section, hNum - 1 - section + mod);

        return sb.toString();
    }

    private static StringBuilder swap(StringBuilder sb, int org, int des){
        char tmp = sb.charAt(org);
        sb.setCharAt(org, sb.charAt(des));
        sb.setCharAt(des, tmp);
        return sb;
    }
    

    /**
     * Primitive idea: for each destination, we can find the target path by using dfs.
     * DFS: Because for each inhabitant can move one-step right or one-step down, if we want to get all of the paths in alphabetically ascending,
     * we can move the inhabitant as right as we can, then going down.
     * @param journeys
     * @return
     */
    public static List<String> getSafePaths(List<String> journeys) {
        // Write your code here
        ans = new ArrayList<>();
        for (String journey : journeys){
            String[] strings = journey.split(" ");
            Cell destination = new Cell(Integer.parseInt(strings[0]), Integer.parseInt(strings[1]));
            count = 0;
            dfs(destination, 0, 0, Integer.parseInt(strings[2]) + 1, new StringBuilder());
        }

        return ans;
    }

    private static void dfs(Cell destination, int x, int y, int num, StringBuilder sb){
        if (count >= num){
            return;
        }
        if (x == destination.x && y == destination.y){
            count += 1;
            if (count == num){
                ans.add(new String(sb));
                return;
            }
        }

        if (x + 1 <= destination.x){
            sb.append("H");
            dfs(destination, x + 1, y,  num, sb);
            sb.deleteCharAt(sb.length() - 1);
        }
        if (y + 1 <= destination.y){
            sb.append("V");
            dfs(destination, x, y + 1,  num, sb);
            sb.deleteCharAt(sb.length() - 1);
        }
    }

    public static void main(String[] args) {
        getSafePaths(Arrays.asList("2 2 0"));
    }
}
