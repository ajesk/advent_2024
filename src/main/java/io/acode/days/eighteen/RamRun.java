package io.acode.days.eighteen;

import io.acode.util.FileReader;
import io.acode.util.Pair;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class RamRun {
    private boolean[][] visited;
    private boolean[][] snowTracker;
    private final int size;
    private final Pair end;
    private final List<Pair> snow;
    private final Pair[] moves = {
            new Pair(0, 1),
            new Pair(1, 0),
            new Pair(-1, 0),
            new Pair(0, -1)
    };

    public RamRun(String file, int size) {
        this(file, size, 0);
    }

    public RamRun(String file, int size, int bytes) {
        visited = new boolean[size][size];
        snowTracker = new boolean[size][size];
        this.size = size;
        this.end = new Pair(size - 1, size - 1);

        snow = FileReader.readFile(file)
                .map(x -> x.split(","))
                .map(x -> new Pair(Integer.parseInt(x[0]), Integer.parseInt(x[1])))
                .toList();

        for (int i = 0; i < bytes; i++) {
            var flake = snow.get(i);
            visited[flake.y()][flake.x()] = true;
        }
    }

    public Pair calculateLastFlake() {
        for (Pair flake : snow) {
            snowTracker[flake.y()][flake.x()] = true;
            visited = Arrays.stream(snowTracker).map(x -> Arrays.copyOf(x, x.length)).toArray(boolean[][]::new);
            if (run() == -1) {
                return flake;
            }
        }
        return null;
    }

    public int run() {
        Queue<Pair> q = new LinkedList<>();
        q.add(new Pair(0, 0));
        q.add(null);
        int moveCount = 0;

        while (!q.isEmpty()) {
            var current = q.poll();

            if (current == null) {
                moveCount++;

                if (!q.isEmpty()) {
                    q.add(null);
                }
                continue;
            } else if (current.equals(end)) {
                return moveCount;
            }

            for (Pair move : moves) {
                var next = new Pair(current, move);

                if (next.y() >= 0 && next.y() < size &&
                        next.x() >= 0 && next.x() < size &&
                        !visited[next.y()][next.x()]
                ) {
                    visited[next.y()][next.x()] = true;
                    q.add(next);
                }
            }
        }

        return -1;
    }
}
