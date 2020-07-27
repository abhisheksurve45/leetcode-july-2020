public class BinaryTreefromInorderPostorderTraversal {

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

        public TreeNode buildTree(int[] inorder, int[] postorder) {
            if (inorder == null || inorder.length == 0 || postorder == null || postorder.length == 0) return null;
            return buildTreeHelper(inorder, postorder, 0, inorder.length - 1, postorder.length - 1);
        }

        // rootIndex : current root index in postorder[]

        private TreeNode buildTreeHelper(int[] inorder, int[] postorder, int start, int end, int rootIndex) {
            if (start > end || rootIndex < 0) return null;

            TreeNode node = new TreeNode(postorder[rootIndex]);

            // find postorder[rootIndex] in inorder[] to grab left-right sub trees
            int i;
            for (i = start; i < end; i++) if (inorder[i] == postorder[rootIndex]) break;

            // i -> rootIndex of postorder[rootIndex] in inorder[]


            // left tree rootIndex -> rootIndex - (end - i + 1)
            node.left = buildTreeHelper(inorder, postorder, start, i - 1, rootIndex - (end - i + 1));

            // straightforward right tree
            node.right = buildTreeHelper(inorder, postorder, i + 1, end, rootIndex - 1);

            return node;
        }
    }
}
