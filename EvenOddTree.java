/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class EvenOddTree {
    public boolean isEvenOddTree(TreeNode root) {
        if (root == null) return true;
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        int l = 0;
        while (!q.isEmpty()) {
            int n = q.size();
            int A[] = new int[n * 2];
            Arrays.fill(A, -1);
            for (int i = 0, j = 0; i < n; i++) {
                TreeNode t = q.poll();
                // System.out.println(t.val);
                if (l % 2 == 0 && t.val % 2 == 0) return false;
                else if (l % 2 != 0 && t.val % 2 != 0) return false;
                if (t.left != null) {
                    q.offer(t.left);
                    // System.out.println(t.left.val);
                    A[j++] = t.left.val;
                } else j++;
                if (t.right != null) {
                    q.offer(t.right);
                    // System.out.println(t.right.val);
                    A[j++] = t.right.val;
                } else j++;
            }
            // System.out.println(Arrays.toString(A));
            l++;
            // System.out.println("LEVEL " + l + " : ");
            List<Integer> ll = new ArrayList<>();
            for (int i : A) if (i != -1) ll.add(i);
            for (int i = 0; i < ll.size() - 1; i++) {
                if (l % 2 == 0) {
                    if (ll.get(i) >= ll.get(i + 1)) return false;
                } else {
                    if (ll.get(i) <= ll.get(i + 1)) return false;
                }
            }
        }
        return true;
    }
}