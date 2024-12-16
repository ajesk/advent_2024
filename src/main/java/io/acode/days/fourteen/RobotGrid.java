package io.acode.days.fourteen;

import io.acode.util.Pair;

public class RobotGrid {

    private final int[][] grid;
    private final boolean[][] touched;
    private final int iteration;

    public RobotGrid(int height, int width, int iteration) {
        this.grid = new int[height][width];
        this.touched = new boolean[height][width];
        this.iteration = iteration;
    }

    public RobotGrid(int height, int width) {
        this(height, width, 0);
    }

    public void record(Pair coordinates) {
        grid[coordinates.y()][coordinates.x()]++;
        touched[coordinates.y()][coordinates.x()] = true;
    }

    public int calculateQuadrants() {
        int q1 = 0, q2 = 0, q3 = 0, q4 = 0;
        int yMid = (grid.length - 1) / 2;
        int xMid = (grid[0].length - 1) / 2;

        for (int y = 0; y < grid.length; y++) {
            for (int x = 0; x < grid[0].length; x++) {
                if (y < yMid) {
                    if (x < xMid) {
                        q1 += grid[y][x];
                    } else if (x > xMid) {
                        q2 += grid[y][x];
                    }
                } else if (y > yMid) {
                    if (x < xMid) {
                        q3 += grid[y][x];
                    } else if (x > xMid) {
                        q4 += grid[y][x];
                    }
                }

            }
        }
            return q1 * q2 * q3 * q4;
    }

    public String print() {
        StringBuilder print = new StringBuilder("_________________________________________________\n");
        print.append("iteration: ").append(iteration).append("\n");

        for (boolean[] booleans : touched) {
            for (boolean aBoolean : booleans) {
                print.append(aBoolean ? "X" : " ");
            }
            print.append("\n");
        }
        return print.toString();
    }
}
