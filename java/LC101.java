class Solution {
    //Iteratively
    public boolean isSymmetric(TreeNode root) {
        if (root == null) {
            return true;
        }
        
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root.left);
        stack.push(root.right);
        
        while(!stack.isEmpty()) {
            TreeNode rNode = stack.pop();
            TreeNode lNode = stack.pop();
            if (rNode == null && lNode == null) {
                continue;
            } else if (rNode == null || lNode == null) {
                return false;
            }
            
            if (rNode.val != lNode.val) {
                return false;
            }
            
            stack.push(lNode.left);
            stack.push(rNode.right);   
            stack.push(lNode.right);
            stack.push(rNode.left);
        }
        
        return true;
    }
    
    //Recursively
    public boolean isSymmetricII(TreeNode root) {
        if (root == null) {
            return true;
        }
        
        return helper(root.left, root.right);
    }
    
    private boolean helper(TreeNode leftNode, TreeNode rightNode) {
        if (leftNode == null && rightNode == null) {
            return true;
        } else if (leftNode == null || rightNode == null) {
            return false;
        }
        
        return helper(leftNode.left, rightNode.right) && helper(leftNode.right, rightNode.left) && (leftNode.val == rightNode.val);
    }
}
