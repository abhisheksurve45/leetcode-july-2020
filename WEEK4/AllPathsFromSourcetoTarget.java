public class AllPathsFromSourcetoTarget {

    /**
     * DFS Approach
     */
    class Solution {
        public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
            List<List<Integer>> allPathsSourceTarget = new ArrayList<>();

            List<Integer> path = new ArrayList<>();
            path.add(0);

            findAllPathsSourceTarget(graph, allPathsSourceTarget, path, 0, graph.length - 1);
            return allPathsSourceTarget;
        }


        private void findAllPathsSourceTarget(int[][] graph, List<List<Integer>> allPathsSourceTarget, List<Integer> path, int start, int target) {
            if (start == target) {
                allPathsSourceTarget.add(new ArrayList<>(path));
                return;
            }

            for (int neighbor : graph[start]) {
                path.add(neighbor);
                findAllPathsSourceTarget(graph, allPathsSourceTarget, path, neighbor, target);
                path.remove(path.size() - 1);
            }
        }
    }

    /**
     * BFS Approach
     */
    class Solution {
        public List<List<Integer>> allPathsSourceTarget(int[][] graph) {

            int target = graph.length - 1;

            List<List<Integer>> allPathsSourceTarget = new ArrayList<>();

            Queue<List<Integer>> q = new LinkedList<>();
            q.add(new ArrayList<>(Arrays.asList(0)));

            while (!q.isEmpty()) {

                List<Integer> path = q.poll();

                int lastNode = path.get(path.size() - 1);

                if (lastNode == target) allPathsSourceTarget.add(new ArrayList<>(path));
                else {
                    int[] neighbors = graph[lastNode];

                    for (int neighbor : neighbors) {
                        List<Integer> list = new ArrayList<>(path);
                        list.add(neighbor);
                        q.offer(list);
                    }
                }
            }
            return allPathsSourceTarget;
        }
    }
}
