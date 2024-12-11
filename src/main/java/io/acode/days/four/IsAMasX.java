package io.acode.days.four;

import java.util.function.BiPredicate;

public class IsAMasX implements BiPredicate<int[], char[][]> {
    private final int[][] moves = new int[][]{
            {-1,-1, 1, 1},
            {-1, 1, 1, -1},
    };

    @Override
    public boolean test(int[] integers, char[][] characters) {
        var y = integers[0];
        var x = integers[1];
        if (characters[y][x] != 'A') return false;

        for (int[] move : moves) {
            var topY = y + move[0];
            var topX = x + move[1];
            var bottomY = y + move[2];
            var bottomX = x + move[3];
            var tCh = characters[topY][topX];
            var bCh = characters[bottomY][bottomX];

            if (!((tCh == 'S' && bCh == 'M') || (tCh == 'M' && bCh == 'S'))) {
               return false;
            }
        }
        return true;
    }
}
