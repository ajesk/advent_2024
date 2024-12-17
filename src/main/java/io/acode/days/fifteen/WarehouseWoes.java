package io.acode.days.fifteen;

import io.acode.util.FileReader;
import io.acode.util.Pair;

import java.util.Map;
import java.util.stream.Collectors;

public class WarehouseWoes {
    String instructions;
    char[][] grid;
    Pair robotLocation;
    Map<Character, Pair> moveLib = Map.of(
            '>', new Pair(0, 1),
            '<', new Pair(0, -1),
            '^', new Pair(-1, 0),
            'v', new Pair(1, 0),
            'V', new Pair(1, 0)
    );

    public WarehouseWoes(String file) {
        var wholeLines = FileReader.readFile(file).filter(x -> !x.isEmpty()).toList();
        instructions = wholeLines.stream().filter(x -> !x.startsWith("#")).collect(Collectors.joining());
        var gridLines = wholeLines.stream().filter(x -> x.startsWith("#"))
                .toList();

        grid = new char[gridLines.size()][gridLines.getFirst().length()];
        for (int y = 0; y < gridLines.size(); y++) {
            String line = gridLines.get(y);
            for (int x = 0; x < gridLines.getFirst().length(); x++) {
                grid[y][x] = line.charAt(x);
                if (grid[y][x] == '@') {
                    robotLocation = new Pair(y, x);
                }
            }
        }
    }

    public void followInstructions() {

        for (char instruction : instructions.toCharArray()) {
            Pair move = moveLib.get(instruction);

            if (moveSpace(robotLocation, move)) {
                robotLocation = new Pair(robotLocation.y() + move.y(), robotLocation.x() + move.x());
            }
        }
    }

    public long getBoxValue() {
        long tally = 0;
        for (int y = 0; y < grid.length; y++) {
            for (int x = 0; x < grid[0].length; x++) {
                if (grid[y][x] == 'O') {
                    tally += 100L * y + x;
                }
            }
        }
        return tally;
    }

    public boolean moveSpace(Pair current, Pair move) {
        Pair next = new Pair(current.y() + move.y(), current.x() + move.x());

        char nextSpace = grid[next.y()][next.x()];
        char currentSpace = grid[current.y()][current.x()];
        if (nextSpace == '#') {
            return false;
        } else if (nextSpace == '.') {
            grid[current.y()][current.x()] = '.';
            grid[next.y()][next.x()] = currentSpace;
            return true;
        }

        if (moveSpace(next, move)) {
            grid[current.y()][current.x()] = '.';
            grid[next.y()][next.x()] = currentSpace;
            return true;
        }
        return false;
    }

}
