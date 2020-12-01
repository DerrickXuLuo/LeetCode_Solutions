class Solution {
    public int maxAncestorDiff(TreeNode root) {
        if (root == null) {
            return 0;
        }
        
        return helper(root, root.val, root.val);
    }
    
    private int helper(TreeNode node, int min, int max) {
        if (node == null) {
            return max - min;
        }   
        
        int curMin = Math.min(min, node.val);
        int curMax = Math.max(max, node.val);
        return Math.max(helper(node.left, curMin, curMax), helper(node.right, curMin, curMax));
    }
}
