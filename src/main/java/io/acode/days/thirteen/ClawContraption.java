package io.acode.days.thirteen;

import io.acode.util.FileReader;
import io.acode.util.Pair;

import java.util.List;

public class ClawContraption {
    private final List<Pair> lines;

    public ClawContraption(String file) {
        lines = FileReader.readFile(file)
                .filter(x -> !x.isEmpty())
                .map(x -> x.replace("Button A: X+", "")
                        .replace("Button B: X+", "")
                        .replace(", Y+", ",")
                        .replace("Prize: X=", "")
                        .replace(", Y=", ",")
                        .split(",")
                ).map(x -> new Pair(Integer.parseInt(x[1]), Integer.parseInt(x[0])))
                .toList();
    }

    public long calculatePrizes() {
        return calculatePrizes(0);
    }

    public long calculatePrizes(long adjustment) {
        long tally = 0;
        for (int i = 0; i < lines.size(); i += 3) {
            tally += new Machine(lines.get(i), lines.get(i + 1), lines.get(i+2)).calculate(adjustment);
        }
        return tally;
    }
}
