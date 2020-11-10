class Solution {
    //Min heap: the size of the heap is k.
    public static int[] topKFrequentMinHeap(int[] nums, int k) {
        if (nums == null || nums.length == 0) {
            return new int[]{};
        }

        List<Integer> ans = new ArrayList<>();
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        PriorityQueue<Integer> queue = new PriorityQueue<Integer>(Comparator.comparingInt(map::get));
        for (Integer key : map.keySet()) {
            queue.offer(key);
            if (queue.size() > k) {
                queue.poll();
            }
        }

        for (Integer num : queue) {
            ans.add(num);
        }

        return ans.stream().mapToInt(i -> i).toArray();
    }

    //MaxHeap: the size of the heap is (map.size()-k)
    public static int[] topKFrequentMaxHeap(int[] nums, int k) {
        if (nums == null || nums.length == 0) {
            return new int[]{};
        }

        List<Integer> ans = new ArrayList<>();
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        PriorityQueue<Integer> queue = new PriorityQueue<Integer>((n1, n2) -> map.get(n2) - map.get(n1));
        for (Integer key : map.keySet()) {
            queue.offer(key);
            if (queue.size() > map.size() - k) {
                ans.add(queue.poll());
            }
        }

        return ans.stream().mapToInt(i -> i).toArray();
    }
}
