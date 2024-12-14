package io.acode.days.twelve;

import java.util.List;

public class CalculatePlot {
    private final int[][] moves = new int[][]{
            {-1, 0},
            {0, -1},
            {0, 1},
            {1, 0},
    };
    private long area = 0;
    private long perimeter = 0;
    private final boolean[][] visited;
    private final List<List<String>> grid;

    public CalculatePlot(boolean[][] visited, List<List<String>> grid) {
        this.visited = visited;
        this.grid = grid;
    }

    public long calculate(int y, int x) {
        visited[y][x] = true;
        dfs(y, x, grid.get(y).get(x));
        return area * perimeter;
    }

    private void dfs(int y, int x, String plot) {
        area++;

        for (int[] move : moves) {
            var nextY = y + move[0];
            var nextX = x + move[1];

            if (nextY >= 0 && nextY < grid.size() &&
                    nextX >= 0 && nextX < grid.getFirst().size() &&
                    grid.get(nextY).get(nextX).equals(plot)
            ) {
                if (!visited[nextY][nextX]) {
                    visited[nextY][nextX] = true;
                    dfs(nextY, nextX, plot);
                }
            } else {
                perimeter++;
            }
        }
    }

}
