package io.acode.days.ten;

import java.util.List;

public class RateTrail {
    private final int[][] moves = new int[][]{
            {-1, 0},
            {0, -1},
            {1, 0},
            {0, 1}
    };
    private final List<List<Integer>> grid;
    private final int height;
    private final int width;

    public RateTrail(List<List<Integer>> grid) {
        this.grid = grid;
        height = grid.size();
        width = grid.getFirst().size();
    }

    public int rate(int y, int x, int elevation) {
        if (elevation == 9) return 1;

        int tally = 0;
        for (int[] move : moves) {
            var nextY = move[0] + y;
            var nextX = move[1] + x;

            if (
                    nextY >= 0 && nextY < height &&
                            nextX >= 0 && nextX < width
            ) {
                var next = grid.get(nextY).get(nextX);
                if (elevation + 1 == next) {
                    tally += rate(nextY, nextX, next);
                }
            }
        }
        return tally;
    }
}
