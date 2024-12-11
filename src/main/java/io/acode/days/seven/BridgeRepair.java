package io.acode.days.seven;

import io.acode.util.FileReader;

import java.util.List;

public class BridgeRepair {
    private final List<List<Long>> ints;
    private final boolean concat;

    public BridgeRepair(String file, boolean concat) {
        ints = FileReader.readFile(file)
                .map(x -> x.replace(":", ""))
                .map(x -> x.split(" "))
                .map(List::of)
                .map(list -> list.stream().map(Long::parseLong).toList())
                .toList();
        this.concat = concat;
    }

    public BridgeRepair(String file) {
        this(file, false);
    }

    public long repairBridge() {
        return ints.stream()
                .mapToLong(line -> recurse(line, 2, line.get(1), line.getFirst()))
                .sum();
    }

    private long recurse(List<Long> arr, int index, long tally, long target) {
        if (tally == target && index == arr.size()) return target;
        if (tally > target || index == arr.size()) return 0L;

        return Math.max(Math.max(
                        recurse(arr, index + 1, tally + arr.get(index), target),
                        recurse(arr, index + 1, tally * arr.get(index), target)),
                concat ? recurse(arr, index + 1, concatLong(tally, arr.get(index)), target) : 0
        );
    }

    private long concatLong(long l1, long l2) {
        return Long.parseLong("" + l1 + l2);
    }
}
