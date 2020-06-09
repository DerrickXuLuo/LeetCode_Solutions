
/**
 * @Author Derrick
 * @CreateTime 6/9/2020 3:07 PM
 * @Desc
 */
public class LC226 {
    /**
     * Recursive way: N is number of the TreeNodes. Time Complexity: O(N); Space Complexity: best case: O(LogN), worst case: O(N)
     * @param root
     * @return
     */
    public TreeNode invertTree(TreeNode root) {
        if (root == null){
            return null;
        }

        TreeNode left = invertTree(root.left);
        TreeNode right = invertTree(root.right);

        root.left = right;
        root.right = left;

        return root;
    }

    /**
     * Iterative way: Time Complexity: O(N); Space Complexity: worst case: all nodes in one level, O(N)
     * @param root
     * @return
     */
    public TreeNode invertTreeII(TreeNode root){
        if (root == null){
            return null;
        }

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()){
            TreeNode curr = queue.poll();
            TreeNode tmp = curr.left;
            curr.left = curr.right;
            curr.right = tmp;
            if (curr.left != null){
                queue.offer(curr.left);
            }
            if (curr.right != null){
                queue.offer(curr.right);
            }
        }

        return root;
    }
}
