public class 3Sum {

    class Solution {
            public List<List<Integer>> threeSum(int[] nums) {

                List<List<Integer>> res = new ArrayList<>();
                if (nums.length == 0) return res;

                Arrays.sort(nums);

                if (nums[0] > 0) return res;

                Map<Integer, Integer> map = new HashMap<>();

                for (int i = 0; i < nums.length - 2; i++) {

                    if (i > 0 && nums[i] > 0) return res;

                    if (i == 0 || (i > 0 && nums[i] != nums[i - 1])) {

                        int low = i + 1;
                        int high = nums.length - 1;
                        int sum = 0 - nums[i];

                        while (low < high) {

                            if (nums[low] + nums[high] == sum) {

                                res.add(Arrays.asList(nums[i], nums[low], nums[high]));
                                while (low < high && nums[low] == nums[low + 1]) low++;
                                while (low < high && nums[high] == nums[high - 1]) high--;
                                low++;
                                high--;

                            } else if (nums[low] + nums[high] < sum) {

                                while (low < high && nums[low] == nums[low + 1]) low++;
                                low++;

                            } else {

                                while (low < high && nums[high] == nums[high - 1]) high--;
                                high--;

                            }
                        }
                    }
                }

                return res;
            }
    }

}
