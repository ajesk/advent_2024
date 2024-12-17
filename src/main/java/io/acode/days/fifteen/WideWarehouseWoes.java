package io.acode.days.fifteen;

import io.acode.util.FileReader;
import io.acode.util.Pair;

import java.util.*;
import java.util.stream.Collectors;

public class WideWarehouseWoes {
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

    public WideWarehouseWoes(String file) {
        var wholeLines = FileReader.readFile(file).filter(x -> !x.isEmpty()).toList();
        instructions = wholeLines.stream().filter(x -> !x.startsWith("#")).collect(Collectors.joining());
        var gridLines = wholeLines.stream().filter(x -> x.startsWith("#"))
                .toList();

        grid = new char[gridLines.size()][gridLines.getFirst().length() * 2];
        for (int y = 0; y < gridLines.size(); y++) {
            String line = gridLines.get(y);
            for (int x = 0; x < gridLines.getFirst().length(); x++) {
                char current = line.charAt(x);
                if (current == '#' || current == '.') {
                    grid[y][x * 2] = current;
                    grid[y][x * 2 + 1] = current;
                } else if (current == 'O') {
                    grid[y][x * 2] = '[';
                    grid[y][x * 2 + 1] = ']';
                } else {
                    robotLocation = new Pair(y, x * 2);
                    grid[y][x * 2] = '@';
                    grid[y][x * 2 + 1] = '.';
                }
            }
        }
    }

    public void followInstructions() {

        for (char instruction : instructions.toCharArray()) {
            Pair move = moveLib.get(instruction);

            if (instruction == '>' || instruction == '<') {
                if (moveHorizontal(robotLocation, move)) {
                    robotLocation = new Pair(robotLocation.y() + move.y(), robotLocation.x() + move.x());
                }
            } else {
                if (moveVertical(robotLocation, move)) {
                    robotLocation = new Pair(robotLocation.y() + move.y(), robotLocation.x() + move.x());
                }
            }
        }
    }

    public long getBoxValue() {
        long tally = 0;
        for (int y = 0; y < grid.length; y++) {
            for (int x = 0; x < grid[0].length; x++) {
                if (grid[y][x] == '[') {
                    tally += 100L * y + x;
                }
            }
        }
        return tally;
    }

    public boolean moveHorizontal(Pair current, Pair move) {
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

        if (moveHorizontal(next, move)) {
            grid[current.y()][current.x()] = '.';
            grid[next.y()][next.x()] = currentSpace;
            return true;
        }
        return false;
    }

    public boolean moveVertical(Pair current, Pair move) {
        Queue<Pair> q = new LinkedList<>();
        Stack<Pair> moves = new Stack<>();
        Set<Pair> visited = new HashSet<>();
        q.add(current);

        while (!q.isEmpty()) {
            Pair currentSpace = q.poll();
            if (visited.contains(currentSpace)) continue;
            visited.add(currentSpace);
            moves.add(currentSpace);
            Pair next = new Pair(currentSpace.y() + move.y(), currentSpace.x() + move.x());
            char nextSpace = grid[next.y()][next.x()];

            if (nextSpace == '#') {
                return false;
            } else if (nextSpace == '[') {
                q.add(next);
                q.add(new Pair(next.y(), next.x() + 1));
            } else if (nextSpace == ']') {
                q.add(new Pair(next.y(), next.x() - 1));
                q.add(next);
            }
        }

        while (!moves.empty()) {
            Pair currentSpot = moves.pop();
            char currentSpace = grid[currentSpot.y()][currentSpot.x()];
            Pair next = new Pair(currentSpot.y() + move.y(), currentSpot.x() + move.x());

            grid[currentSpot.y()][currentSpot.x()] = '.';
            grid[next.y()][next.x()] = currentSpace;
        }

        return true;
    }

}
