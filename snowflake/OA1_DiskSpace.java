package com.company.review.algorithms;

import java.util.*;

/**
 * @Author Derrick
 * @CreateTime 6/26/2020 9:17 PM
 * @Desc
 */
public class Disk {
    static class Cell{
        int x;
        int val;
        public Cell(int x, int val){
            this.x = x;
            this.val = val;
        }
    }

    public static int segment(int x, List<Integer> space) {
        // Write your code here
        List<Integer> list = new ArrayList<>();
//        PriorityQueue<Cell> pq = new PriorityQueue<>(new Comparator<Cell>() {
//            @Override
//            public int compare(Cell o1, Cell o2) {
//                if (o1.val - o2.val < 0){
//                    return -1;
//                }else if (o1.val - o2.val > 0){
//                    return 1;
//                }else {
//                    return 0;
//                }
//            }
//        });
        TreeSet<Cell> treeSet = new TreeSet<>(new Comparator<Cell>() {
            @Override
            public int compare(Cell o1, Cell o2) {
                return Integer.compare(o1.val - o2.val, 0);
            }
        });

        Map<Integer, Cell> map = new HashMap<>();
        for (int i = 0; i + x <= space.size(); i++){
            if (i == 0){
                for (int j = i; j < i + x; j++){
                    Cell cell = new Cell(j, space.get(j));
                    treeSet.add(cell);
                    map.put(j, cell);
                }
            }else {
                Cell cell = new Cell(i + x - 1, space.get(i + x - 1));
                treeSet.add(cell);
                map.put(i + x - 1, cell);
            }

            list.add(treeSet.first().val);
            treeSet.remove(map.get(i));

//            Cell cell = new Cell(i, space.get(i));
//            if (i == 0){
//                for (int j = i; j < i + x; j++){
//                    if (j == i){
//                        pq.offer(cell);
//                    }else {
//                        pq.offer(new Cell(i, space.get(j)));
//                    }
//                }
//            }else {
//                pq.offer(new Cell(i + x, space.get(i + x)));
//            }
//            list.add(pq.peek().val);
//            pq.remove(cell);
        }

        int ans = Integer.MIN_VALUE;
        for (int num : list){
            ans = Math.max(num, ans);
        }

        return ans;
    }

    public static void main(String[] args) {
        int[] arr = new int[]{1,5,1,2,3,1,2};
        segment(1,Arrays.asList(1,5,1,2,3,1,2));

    }
}
