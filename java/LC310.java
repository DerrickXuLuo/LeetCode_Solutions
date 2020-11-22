class Solution {
    public List<Integer> findMinHeightTrees(int n, int[][] edges) {
        if (n < 2) {
            ArrayList<Integer> centroids = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                centroids.add(i);
            }
            return centroids;
        }
        
        List<Set<Integer>> neighbours = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            neighbours.add(new HashSet<>());
        }
        
        for (int[] edge : edges) {
            Integer start = edge[0];
            Integer end = edge[1];
            neighbours.get(start).add(end);
            neighbours.get(end).add(start);
        }
        
        //leaves
        List<Integer> leaves = new ArrayList<>();
        for (int i = 0; i < neighbours.size(); i++) {
            if (neighbours.get(i).size() == 1) {
                leaves.add(i);
            }
        }
        
        int remainingNodes = n;
        while (remainingNodes > 2) {
            remainingNodes -= leaves.size();
            List<Integer> newLeaves = new ArrayList<>();
            
            for (Integer leaf : leaves) {
                Integer neighbour = neighbours.get(leaf).iterator().next();
                neighbours.get(neighbour).remove(leaf);
                if (neighbours.get(neighbour).size() == 1) {
                    newLeaves.add(neighbour);
                }
            }
            
            leaves = newLeaves;
        }
        
        return leaves;
    }
}
