public class TaskScheduler {

    /**
     * Intutive approach
     */
    class Solution {
        public int leastInterval(char[] tasks, int n) {

            // current elapsed time
            int currentTime = 0;

            // stores task frequency : A -> 2, B -> 3
            Map<Integer, Integer> taskFreq = new HashMap<>();

            // stores cooldowned tasks with freq left : A -> 1, B -> 2
            Map<Integer, Integer> coolDown = new HashMap<>();

            // populate freq map
            for (int task : tasks) {
                taskFreq.put(task, taskFreq.getOrDefault(task, 0) + 1);
            }

            // pq for storing tasks in desc acc to freq
            PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
            pq.addAll(taskFreq.values());

            while (!pq.isEmpty() || !coolDown.isEmpty()) {

                // if any cooldown task is left, add it to queue
                if (coolDown.containsKey(currentTime - n - 1)) {
                    pq.offer(coolDown.remove(currentTime - n - 1));
                }

                if (!pq.isEmpty()) {

                    // add incomplete tasks to cooldown
                    int left = pq.poll() - 1;
                    if (left != 0) coolDown.put(currentTime, left);
                }

                // increment current elapsed time
                currentTime++;
            }

            return currentTime;
        }
    }

    /**
     * Approach based on : https://leetcode.com/problems/task-scheduler/discuss/760131/Java-Concise-Solution-Intuition-Explained-in-Detail
     */
    class Solution {
        public int leastInterval(char[] tasks, int n) {

            int[] maxFreq = new int[26];

            for (char c : tasks) maxFreq[c - 'A']++;

            Arrays.sort(maxFreq);

            int max = maxFreq[25] - 1;
            int spaces = max * n;

            for (int i = 24; i >= 0; i--) {

                spaces -= Math.min(maxFreq[i], max);
            }

            spaces = Math.max(0, spaces);

            return tasks.length + spaces;
        }
    }
}
