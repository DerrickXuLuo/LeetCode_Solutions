class Solution {
    private int sum = 0;
    public int findTilt(TreeNode root) {
        helper(root);
        return sum;
    }
    
    private int helper(TreeNode node) {
        if (node == null) {
            return 0;
        }
        
        int leftSum = helper(node.left);
        int rightSum = helper(node.right);
        int tilt = Math.abs(leftSum - rightSum);
        sum += tilt;
        
        return leftSum + rightSum + node.val;
    }
}
