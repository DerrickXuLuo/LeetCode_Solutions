/**
 * @Author Derrick
 * @CreateTime 6/19/2020 12:51 PM
 * @Desc Finding Lowest Common Ancestor in the BST: Primitively, we can utilize the solution of the Finding Lowest Common Ancestor in the Binary Tree,.
 * However, we can improve the solution by utilizing the properties of the BST, so that we can terminate the recursive process early.
 * But in the worst case, the time complexity of the optimized solution is still O(N).
 */
public class LC235 {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null || root == p || root == q) {
            return root;
        }

        TreeNode lChild = lowestCommonAncestor(root.left, p, q);
        TreeNode rChild = lowestCommonAncestor(root.right, p, q);

        if (lChild != null && rChild != null) {
            return root;
        }

        return lChild == null ? rChild : lChild;
    }

    public TreeNode lowestCommonAncestorII(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null || root == p || root == q) {
            return root;
        }

        int rootVal = root.val, pVal = p.val, qVal = q.val;

        //Utilize the properties of the BST
        if (pVal > rootVal && qVal > rootVal){
            return lowestCommonAncestorII(root.right, p, q);
        }else if (pVal < rootVal && qVal < rootVal){
            return lowestCommonAncestorII(root.left, p, q);
        }else {
            return root;
        }
    }
}
