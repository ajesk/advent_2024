package io.acode.days.sixteen;

import io.acode.util.FileReader;
import io.acode.util.Pair;

import java.util.*;

public class ReindeerMaze {
    private final char[][] grid;
    private final int[][] totals;
    private Move start;
    private Pair end;
    private final Pair[] moves = {
            new Pair(0, 1),
            new Pair(1, 0),
            new Pair(0, -1),
            new Pair(-1, 0)
    };
    private final Set<Pair> bestSpaces = new HashSet<>();

    public ReindeerMaze(String file) {
        var lines = FileReader.readFile(file).toList();

        grid = new char[lines.size()][lines.getFirst().length()];
        totals = new int[lines.size()][lines.getFirst().length()];
        for (int y = 0; y < lines.size(); y++) {
            Arrays.fill(totals[y], Integer.MAX_VALUE);

            for (int x = 0; x < lines.getFirst().length(); x++) {
                grid[y][x] = lines.get(y).charAt(x);
                if (grid[y][x] == 'S') {
                    var startCoordinate = new Pair(y, x);
                    start = new Move(startCoordinate, 0, 0, Set.of(startCoordinate));
                } else if (grid[y][x] == 'E') {
                    end = new Pair(y, x);
                }
            }
        }
    }

    public int findShortestPath() {
        Queue<Move> q = new LinkedList<>();
        q.add(start);

        while (!q.isEmpty()) {
            var current = q.poll();
            var currentLoc = current.coordinates();
            if (totals[currentLoc.y()][currentLoc.x()] < current.tally()) {
                continue;
            }

            Set<Pair> currentMoves = new HashSet<>(current.previousMoves());
            currentMoves.add(current.coordinates());
            if (grid[currentLoc.y()][currentLoc.x()] == 'E') {
                if (totals[currentLoc.y()][currentLoc.x()] == current.tally()) {
                    bestSpaces.addAll(currentMoves);
                } else if (totals[currentLoc.y()][currentLoc.x()] > current.tally()) {
                    bestSpaces.clear();
                    bestSpaces.addAll(currentMoves);
                    totals[currentLoc.y()][currentLoc.x()] = current.tally();
                }
                continue;
            }

            totals[currentLoc.y()][currentLoc.x()] = current.tally();

            Pair move;
            Pair nextSpace;

            // try right
            var rightTurn = (current.direction() + 1) % 4;
            move = moves[rightTurn];
            nextSpace = new Pair(currentLoc.y() + move.y(), currentLoc.x() + move.x());
            if (grid[nextSpace.y()][nextSpace.x()] != '#') {
                q.add(new Move(nextSpace, rightTurn, current.tally() + 1001, currentMoves));
            }

            // try left
            var leftTurn = current.direction() - 1;
            if (leftTurn == -1) leftTurn += 4;
            move = moves[leftTurn];
            nextSpace = new Pair(currentLoc.y() + move.y(), currentLoc.x() + move.x());
            if (grid[nextSpace.y()][nextSpace.x()] != '#') {
                q.add(new Move(nextSpace, leftTurn, current.tally() + 1001, currentMoves));
            }

            move = moves[current.direction()];
            nextSpace = new Pair(currentLoc.y() + move.y(), currentLoc.x() + move.x());
            if (grid[nextSpace.y()][nextSpace.x()] != '#') {
                q.add(new Move(nextSpace, current.direction(), current.tally() + 1, currentMoves));
            }
        }

        return totals[end.y()][end.x()];
    }

    public final int findBestSpots() {
        findShortestPath();
        return bestSpaces.size();
    }
}
