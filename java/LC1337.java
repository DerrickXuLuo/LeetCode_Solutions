package solution;

import java.util.Comparator;
import java.util.PriorityQueue;

public class LC1337 {
    public static int[] kWeakestRows(int[][] mat, int k) {
        if (mat.length == 0 || mat[0].length == 0) {
            return new int[]{};
        }

        int[] ans = new int[k];
        Comparator<int[]> comparator = new Comparator<int[]>() {
            @Override
            public int compare(int[] a, int[] b) {
                if (a[0] == b[0]) {
                    return b[1] - a[1];
                } else {
                    return b[0] - a[0];
                }
            }
        };

        PriorityQueue<int[]> pq = new PriorityQueue<>(comparator);

        for (int i = 0; i < mat.length; i++) {
            int[] row = mat[i];
            int oneCount = getCount(row);

            pq.offer(new int[]{oneCount, i});
            if (pq.size() > k) {
                pq.poll();
            }
        }

        int i = k - 1;
        while (i >= 0) {
            if (!pq.isEmpty()) {
                ans[i] = pq.poll()[1];
            }
            i--;
        }

        return ans;
    }

    // log(n)
    private static int getCount(int[] row) {
        int low = 0;
        int high = row.length;
        while (low < high) {
            int mid = low + (high - low) / 2;
            if (row[mid] == 1) {
                low = mid + 1;
            } else {
                high = mid;
            }
        }

        return low;
    }

    public static void main(String[] args) {
        kWeakestRows(new int[][]{{1,1,0,0,0},{1,1,1,1,0},{1,0,0,0,0},{1,1,0,0,0},{1,1,1,1,1}}, 3);




    }
}
