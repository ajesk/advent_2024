package io.acode.days.ten;

import io.acode.util.FileReader;

import java.util.List;

public class HoofIt {
    private final List<List<Integer>> grid;

    public HoofIt(String file) {
        ProcessInput processInput = new ProcessInput();
        this.grid = FileReader.readFile(file)
                .map(processInput)
                .toList();
    }

    public int findTrailHeads() {
        int tally = 0;
        for (int y = 0; y < grid.size(); y++) {
            for (int x = 0; x < grid.getFirst().size(); x++) {
                if (grid.get(y).get(x) == 0) {
                    tally += new NavigateTrail(grid).navigate(y, x, 0);
                }
            }
        }
        return tally;
    }

    public int findTrailRatings() {
        int tally = 0;
        for (int y = 0; y < grid.size(); y++) {
            for (int x = 0; x < grid.getFirst().size(); x++) {
                if (grid.get(y).get(x) == 0) {
                    tally += new RateTrail(grid).rate(y, x, 0);
                }
            }
        }
        return tally;
    }
}
