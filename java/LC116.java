public class LC116 {
    /**
     * Recursive solution
     * @param root
     * @return
     */
    public Node connect(Node root){
        helper(null, root);
        return root;
    }

    private void helper(Node prev, Node root){
        if (root == null){
            return;
        }

        if (prev != null){
            prev.next = root;
            helper(prev.right, root.left);
        }else {
            helper(null, root.left);
        }

        helper(root.left, root.right);
    }

    /**
     * Iterative solution
     * @param root
     * @return
     */
    public Node connectII(Node root){
        Node level = root;
        while (level != null){
            Node curr = level;
            while (curr != null){
                if (curr.left != null){
                    curr.left.next = curr.right;
                }
                if (curr.next != null && curr.right != null){
                    curr.right.next = curr.next.left;
                }
                curr = curr.next;
            }

            level = level.left;
        }

        return root;
    }
}
