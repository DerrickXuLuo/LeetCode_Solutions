public class LC117 {
    public Node connect(Node root) {
        Node level = root;
        while (level != null){
            Node curr = level;
            Node prev = null;
            while (curr != null){
                if (curr.left != null){
                    if (prev != null){
                        prev.next = curr.left;
                    }
                    prev = curr.left;
                }
                if (curr.right != null){
                    if (prev != null){
                        prev.next = curr.right;
                    }
                    prev = curr.right;
                }

                curr = curr.next;
            }

            if (level.left != null){
                level = level.left;
            }else if (level.right != null){
                level = level.right;
            }else {
                level = level.next;
            }
        }

        return root;
    }
}
