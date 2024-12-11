package io.acode.days.six;

import java.util.Arrays;

public class Guard {
    private final int[][] moves = new int[][]{
            {-1, 0},
            {0, 1},
            {1, 0},
            {0, -1}
    };
    private int direction = 0;
    private int moveCount = 0;
    private final int[] position;

    public Guard(int[] position) {
        this.position = position;
    }

    public Guard(Guard old) {
        direction = old.direction;
        position = Arrays.copyOf(old.getPosition(), old.getPosition().length);
    }

    public void rotate() {
        direction = (direction + 1) % 4;
    }

    public int getDirection() {
        return direction;
    }

    public int[] getNextPosition() {
        int[] move = moves[direction];
        return new int[]{position[0] + move[0], position[1] + move[1]};
    }

    public int[] getPosition() {
        return position;
    }

    public void performMove() {
        int[] move = moves[direction];
        position[0] += move[0];
        position[1] += move[1];
        moveCount++;
    }

    public int getMoveCount() {
        return moveCount;
    }
}
