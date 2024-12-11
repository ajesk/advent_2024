package io.acode.days.six;

import java.util.ArrayList;
import java.util.List;

public class GuardMap {
    private final List<List<Character>> grid;
    private static final char ROCK = '#';
    private static final char GUARD = '^';

    public GuardMap(List<List<Character>> grid) {
        this.grid = grid;
    }

    public GuardMap(GuardMap guardMap) {
        grid = new ArrayList<>();
        guardMap.grid.forEach(row -> {
            grid.add(new ArrayList<>(row));
        });
    }

    public int[] findGuardPosition() {
        for (int y = 0; y < grid.size(); y++) {
            for (int x = 0; x < grid.getFirst().size(); x++) {
                if (grid.get(y).get(x).equals(GUARD)) {
                    return new int[]{y, x};
                }
            }
        }
        return new int[]{-1, -1};
    }

    public int countVisitedSpaces() {
        int result = 0;
        for (int y = 0; y < grid.size(); y++) {
            for (int x = 0; x < grid.getFirst().size(); x++) {
                if (grid.get(y).get(x).equals(GUARD)) {
                    result++;
                }
            }
        }
        return result;
    }

    public void markMove(int[] position) {
        if (!positionValid(position)) return;

        grid.get(position[0]).set(position[1], GUARD);
    }

    public boolean isRockAt(int[] position) {
        return positionValid(position) &&
                grid.get(position[0]).get(position[1]).equals(ROCK);
    }

    public boolean positionValid(int[] position) {
        return position[0] >= 0 && position[0] < grid.size() &&
                position[1] >= 0 && position[1] < grid.getFirst().size();
    }

    public void setRock(int[] position) {
        if (positionValid(position)) {
            grid.get(position[0]).set(position[1], '#');
        }
    }
}
