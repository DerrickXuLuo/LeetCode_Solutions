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
