public class BinaryTreeLevelOrderTraversalII {

    /**
     * Definition for a binary tree node.
     * public class TreeNode {
     * int val;
     * TreeNode left;
     * TreeNode right;
     * TreeNode() {}
     * TreeNode(int val) { this.val = val; }
     * TreeNode(int val, TreeNode left, TreeNode right) {
     * this.val = val;
     * this.left = left;
     * this.right = right;
     * }
     * }
     */
    class Solution {
        public List<List<Integer>> levelOrderBottom(TreeNode root) {
            List<List<Integer>> result = new ArrayList<>();
            if (root == null) return result;
            Queue<TreeNode> q = new LinkedList();
            q.add(root);

            while (!q.isEmpty()) {
                int rowSize = q.size();
                List<Integer> row = new ArrayList<>();
                while (rowSize > 0) {
                    TreeNode currentNode = q.poll();
                    if (currentNode.left != null) {
                        q.add(currentNode.left);
                    }

                    if (currentNode.right != null) {
                        q.add(currentNode.right);
                    }
                    row.add(currentNode.val);
                    rowSize--;
                }
                result.add(0, row);
            }

            return result;
        }
    }
}
