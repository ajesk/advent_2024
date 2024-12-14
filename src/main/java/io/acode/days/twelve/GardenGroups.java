package io.acode.days.twelve;

import io.acode.util.FileReader;

import java.util.List;

public class GardenGroups {
    private final List<List<String>> grid;
    private final boolean[][] visited;

    public GardenGroups(String file) {
        grid = FileReader.readFile(file)
                .map(line -> line.split(""))
                .map(List::of)
                .toList();
        visited = new boolean[grid.size()][grid.getFirst().size()];
    }

    public long getGroupCounts() {
        long result = 0;

        for (int y = 0; y < grid.size(); y++) {
            for (int x = 0; x < grid.getFirst().size(); x++) {
                if (!visited[y][x]) {
                    result += new CalculatePlot(visited, grid).calculate(y, x);
                }
            }
        }
        return result;
    }
}
