public class Subsets {


    /**
     * Recursive approach
     * Reference : https://leetcode.com/problems/subsets/discuss/27281/A-general-approach-to-backtracking-questions-in-Java-(Subsets-Permutations-Combination-Sum-Palindrome-Partitioning)
     */
    class Solution {
        public List<List<Integer>> subsets(int[] nums) {
            List<List<Integer>> subsets = new ArrayList<>();
            if (nums.length == 0) return subsets;
            generateSubsets(nums, 0, new ArrayList<>(), subsets);
            return subsets;
        }

        private void generateSubsets(int[] nums, int index, List<Integer> currSubset, List<List<Integer>> subsets) {
            subsets.add(new ArrayList<>(currSubset));
            for (int i = index; i < nums.length; i++) {
                currSubset.add(nums[i]);
                generateSubsets(nums, i + 1, currSubset, subsets);
                currSubset.remove(currSubset.size() - 1);
            }
        }
    }


    /**
     * BFS approach
     * Reference : https://leetcode.com/problems/subsets/discuss/729961/Iterative-BFS-Solution-Detailed-Explanation
     */
    class Solution {
        public List<List<Integer>> subsets(int[] nums) {
            List<List<Integer>> subsets = new ArrayList<>();
            if (nums.length == 0) return subsets;

            // EMPTY LIST
            subsets.add(new ArrayList<>());

            for (int num : nums) {
                int size = subsets.size();
                for (int i = 0; i < size; i++) {
                    List<Integer> subset = new ArrayList(subsets.get(i));
                    subset.add(num);
                    subsets.add(subset);
                }
            }

            return subsets;
        }

    }
}
