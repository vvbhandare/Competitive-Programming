class UnivaluedBinaryTree {
    public boolean isUnivalTree(TreeNode root) {
        if (root == null) return true;
        return preorder(root, root.val);
    }
    
    private boolean preorder(TreeNode root, int prev) {
        if (root == null) return true;
        if (root.val != prev) return false;
        return preorder(root.left, prev) && preorder(root.right, prev);
    }
}