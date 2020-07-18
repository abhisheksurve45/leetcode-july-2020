public class CourseScheduleII {

    /**
     * Similar to CourseSchedule : https://github.com/abhisheksurve45/leetcode-may-2020/blob/master/WEEK5/CourseSchedule.java
     */
    class Solution {
        public int[] findOrder(int numCourses, int[][] prerequisites) {

            List<Integer> result = new ArrayList<>();
            List<Integer>[] graph = new ArrayList[numCourses];

            for (int i = 0; i < numCourses; i++) {
                graph[i] = new ArrayList();
            }

            int[] inDegree = new int[numCourses];

            for (int[] e : prerequisites) {
                inDegree[e[1]]++;
                graph[e[0]].add(e[1]);
            }

            Queue<Integer> q = new LinkedList<Integer>();

            for (int i = 0; i < inDegree.length; i++) {
                if (inDegree[i] == 0) q.add(i);
            }

            while (!q.isEmpty()) {

                int curr = q.poll();
                result.add(0, curr);

                for (int e : graph[curr]) {
                    inDegree[e]--;
                    if (inDegree[e] == 0) q.add(e);
                }
                numCourses--;
            }

            return numCourses == 0 ? result.stream().mapToInt(Integer::intValue).toArray() : new int[0];
        }
    }
}
