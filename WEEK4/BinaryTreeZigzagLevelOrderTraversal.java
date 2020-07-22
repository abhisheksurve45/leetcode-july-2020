public class BinaryTreeZigzagLevelOrderTraversal {
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
        public List<List<Integer>> zigzagLevelOrder(TreeNode root) {

            List<List<Integer>> zigzagLevelOrder = new ArrayList<>();

            if (root == null) return zigzagLevelOrder;

            Stack<TreeNode> currentLevel = new Stack<>();
            Stack<TreeNode> nextLevel = new Stack<>();

            currentLevel.push(root);

            while (!currentLevel.isEmpty()) {

                List<Integer> levelNodes = new ArrayList<>();

                while (!currentLevel.isEmpty()) {
                    TreeNode curr = currentLevel.pop();

                    levelNodes.add(curr.val);

                    if (curr.left != null) {
                        nextLevel.push(curr.left);
                    }
                    if (curr.right != null) {
                        nextLevel.push(curr.right);
                    }
                }

                zigzagLevelOrder.add(levelNodes);

                levelNodes = new ArrayList<>();

                while (!nextLevel.isEmpty()) {
                    TreeNode curr = nextLevel.pop();

                    levelNodes.add(curr.val);

                    if (curr.right != null) {
                        currentLevel.push(curr.right);
                    }
                    if (curr.left != null) {
                        currentLevel.push(curr.left);
                    }
                }

                if (!levelNodes.isEmpty()) zigzagLevelOrder.add(levelNodes);

            }

            return zigzagLevelOrder;
        }
    }
}
