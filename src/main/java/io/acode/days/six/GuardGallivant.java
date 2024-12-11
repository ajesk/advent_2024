package io.acode.days.six;

import io.acode.util.FileReader;

import java.util.ArrayList;
import java.util.List;

public class GuardGallivant {
    GuardMap guardMap;
    Guard guard;
    MoveTracker moveTracker;
    boolean[][] rocks;

    public GuardGallivant(String fileName) {
        var lines = FileReader.readFile(fileName)
                .map(String::toCharArray)
                .map(charLine -> {
                    List<Character> gridLine = new ArrayList<>();
                    for (char ch : charLine) {
                        gridLine.add(ch);
                    }
                    return gridLine;
                }).toList();
        guardMap = new GuardMap(lines);
        guard = new Guard(guardMap.findGuardPosition());
        moveTracker = new MoveTracker(lines.size(), lines.getFirst().size());
        rocks = new boolean[lines.size()][lines.getFirst().size()];
    }

    public int trackGuardLocations() {
        while (guardMap.positionValid(guard.getPosition())) {
            int[] nextPosition = guard.getNextPosition();

            if (guardMap.isRockAt(nextPosition)) {
                guard.rotate();
            } else {
                guard.performMove();
                guardMap.markMove(guard.getPosition());
            }
        }
        return guardMap.countVisitedSpaces();
    }

    public int simulateBlockingGuard() {
        int result = 0;

        while (guardMap.positionValid(guard.getPosition())) {
            if (guardMap.isRockAt(guard.getNextPosition())) {
                guard.rotate();
            } else {
                GuardSimulator simulator = new GuardSimulator(moveTracker, guardMap, guard, rocks);
                if (simulator.runSimulation()) {
                   result++;
                }
                guard.performMove();
            }
        }
        return result;
    }
}
