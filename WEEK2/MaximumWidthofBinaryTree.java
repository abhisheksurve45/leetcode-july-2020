public class MaximumWidthofBinaryTree {

    /**
     * Approach 1 : Recursive DFS
     */
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
        public int widthOfBinaryTree(TreeNode root) {
            List<Integer> levelLMN = new ArrayList<>();
            return dfs(root, 1, 0, levelLMN);
        }

        private int dfs(TreeNode root, int id, int level, List<Integer> levelLMN) {
            if (root == null) return 0;
            if (level == levelLMN.size()) levelLMN.add(id);
            return Math.max(id + 1 - levelLMN.get(level),
                    Math.max(dfs(root.left, id * 2, level + 1, levelLMN),
                            dfs(root.right, id * 2 + 1, level + 1, levelLMN)));
        }
    }

    /**
     * Approach 2 : BFS
     * Reference : https://www.youtube.com/watch?v=qCAbp1f9T5o
     */
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
        public int widthOfBinaryTree(TreeNode root) {
            if (root == null) return 0;

            int widthOfBinaryTree = 0;
            Queue<Pair<TreeNode, Integer>> q = new LinkedList<>();
            q.offer(new Pair(root, 0));

            while (!q.isEmpty()) {
                int size = q.size();
                Pair<TreeNode, Integer> first = q.peek();
                Pair<TreeNode, Integer> curr = null;
                while (size-- > 0) {
                    curr = q.poll();
                    int index = curr.getValue();
                    TreeNode node = curr.getKey();
                    if (node.left != null) q.offer(new Pair(node.left, index * 2));
                    if (node.right != null) q.offer(new Pair(node.right, index * 2 + 1));
                }

                widthOfBinaryTree = Math.max(widthOfBinaryTree, curr.getValue() - first.getValue() + 1);
            }

            return widthOfBinaryTree;
        }
    }
}
