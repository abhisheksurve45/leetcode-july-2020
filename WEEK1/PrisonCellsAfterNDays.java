public class PrisonCellsAfterNDays {


    /**
     * Reference : https://www.youtube.com/watch?v=secuBlDy0YQ
     */
    class Solution {
        public int[] prisonAfterNDays(int[] cells, int N) {
            Set<String> seen = new HashSet();
            boolean cycle = false;
            int len = 0;
            for (int i = 0; i < N; i++) {
                int[] next = nextDayState(cells);
                String key = Arrays.toString(next);
                if (seen.contains(key)) {
                    cycle = true;
                    break;
                }
                seen.add(key);
                len++;
                cells = next;
            }

            if (cycle)
                return prisonAfterNDays(cells, N % len);
            return cells;
        }

        private int[] nextDayState(int[] cells) {
            int[] next = new int[cells.length];
            for (int i = 1; i < 7; i++)
                next[i] = cells[i - 1] == cells[i + 1] ? 1 : 0;
            return next;
        }
    }
}
