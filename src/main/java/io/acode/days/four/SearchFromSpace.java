package io.acode.days.four;

import java.util.function.BiFunction;

public class SearchFromSpace implements BiFunction<int[], char[][], Integer> {
    private final char[] searchString = new char[]{'M', 'A', 'S'};
    private final int[][] moves = new int[][]{
            {-1,-1},
            {-1, 0},
            {-1, 1},
            {0, -1},
            {0, 1},
            {1, -1},
            {1, 0},
            {1, 1},
    };

    @Override
    public Integer apply(int[] integers, char[][] characters) {
        var startY = integers[0];
        var startX = integers[1];
        int countFromIndex = 0;
        if (characters[startY][startX] != 'X') return 0;

        for (int[] move : moves) {
            var y = startY;
            var x = startX;
            for (char letter : searchString) {
                y += move[0];
                x += move[1];
                if (y >= 0 && y < characters.length && x >= 0 && x < characters.length) {
                    var current = characters[y][x];
                    if (letter != current) {
                        break;
                    } else if (letter == searchString[searchString.length - 1]) {
                        countFromIndex++;
                    }
                }
            }
        }
        return countFromIndex;
    }
}
