package io.acode.days.eight;

import io.acode.util.FileReader;

import java.util.*;

public class ResonantCollinearity {
    private final Map<Character, List<Coordinate>> antenna = new HashMap<>();
    private final boolean propagate;
    List<String> lines;

    public ResonantCollinearity(String file, boolean propagate) {
        this.propagate = propagate;
        lines = FileReader.readFile(file).toList();
        for (int y = 0; y < lines.size(); y++) {
            for (int x = 0; x < lines.getFirst().length(); x++) {
                if (lines.get(y).charAt(x) == '.') continue;
                antenna.computeIfAbsent(lines.get(y).charAt(x), (i) -> new ArrayList<>())
                        .add(new Coordinate(y, x));
            }
        }
    }

    public ResonantCollinearity(String file) {
        this(file, false);
    }

    public int findAntinodes() {
        Set<Coordinate> signals = new HashSet<>();

        antenna.forEach((key, ants) -> {

            for (int a = 0; a < ants.size(); a++) {
                for (int b = a + 1; b < ants.size(); b++) {
                    var nodeA = ants.get(a);
                    var nodeB = ants.get(b);
                    signals.addAll(propegateAntinode(nodeA, nodeB));
                    signals.addAll(propegateAntinode(nodeB, nodeA));
                }
            }
            if (propagate) {
                signals.addAll(ants);
            }
        });

        return signals.size();
    }

    private List<Coordinate> propegateAntinode(Coordinate nodeA, Coordinate nodeB) {
        final var yDiff = Math.abs(nodeB.y() - nodeA.y());
        final var xDiff = Math.abs(nodeB.x() - nodeA.x());
        final var yDir = nodeA.y() > nodeB.y();
        final var xDir = nodeA.x() > nodeB.x();
        final List<Coordinate> coordinates = new ArrayList<>();
        int lastY = nodeA.y();
        int lastX = nodeA.x();

        do {
            int nextY = yDir ? lastY + yDiff : lastY - yDiff;
            int nextX = xDir ? lastX + xDiff : lastX - xDiff;
            lastY = nextY;
            lastX = nextX;
            var nextCoordinate = new Coordinate(nextY, nextX);
            if (isValidSignal(nextCoordinate)) {
                coordinates.add(nextCoordinate);
            } else {
                break;
            }
        } while (propagate);

        return coordinates;
    }

    private boolean isValidSignal(Coordinate coordinate) {
        return coordinate.y() >= 0 && coordinate.y() < lines.size() &&
                coordinate.x() >= 0 && coordinate.x() < lines.getFirst().length();
    }

    protected record Coordinate(int y, int x) {
    }
}
