public class IslandPerimeter {
    class Solution {

        /**
         * Reference : https://www.youtube.com/watch?v=FkjFlNtTzc8
         * @param grid
         * @return
         */
        public int islandPerimeter(int[][] grid) {
            int islandPerimeter = 0;

            if (grid.length == 0 || grid[0].length == 0) return islandPerimeter;

            for (int i = 0; i < grid.length; i++) {
                for (int j = 0; j < grid[0].length; j++) {
                    if (grid[i][j] == 1) {

                        islandPerimeter += 4;
                        if (i > 0 && grid[i - 1][j] == 1) {
                            islandPerimeter -= 2;
                        }
                        if (j > 0 && grid[i][j - 1] == 1) {
                            islandPerimeter -= 2;
                        }

                    }
                }
            }

            return islandPerimeter;
        }
    }
}
