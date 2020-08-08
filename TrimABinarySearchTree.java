class TrimABinarySearchTree {
    
    public TreeNode trimBST(TreeNode root, int L, int R) {
        return dfs(root, L, R);
    }
    
    private TreeNode dfs(TreeNode root, int L, int R) {
        if (root == null) return root;
        if (root.val == L) {
            root.left = null;
            root.right = dfs(root.right, L, R);
        } else if (root.val == R) {
            root.left = dfs(root.left, L, R);
            root.right = null;
        } else if (root.val > L && root.val < R) {
            root.left = dfs(root.left, L, R);
            root.right = dfs(root.right, L, R);
        } else if (root.val > L && root.val > R) {
            root = dfs(root.left, L, R);
        } else if (root.val < L && root.val < R) {
            root = dfs(root.right, L, R);
        }
        return root;
    }
}