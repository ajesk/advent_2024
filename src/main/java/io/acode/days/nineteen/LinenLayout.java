package io.acode.days.nineteen;

import io.acode.util.FileReader;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LinenLayout {
    private final List<String> towels;
    private final List<String> lines;

    public LinenLayout(String file) {
        lines = FileReader.readFile(file)
                .filter(x -> !x.isEmpty())
                .filter(x -> !x.contains(","))
                .toList();
        towels = List.of(FileReader.readFile(file).findFirst().orElse("").split(", "));
    }

    public int countMatches() {
        int count = 0;
        for (String line : lines) {
            if (dp(line, new HashMap<>())) count++;
        }
        return count;
    }

    public boolean dp(String current, Map<String, Boolean> memo) {
       if (current.isEmpty()) {
           return true;
       }
       if (memo.containsKey(current)) {
           return memo.get(current);
       }

       for (String towel : towels) {
           if (current.startsWith(towel)) {
               if (dp(current.substring(towel.length()), memo)) {
                   memo.put(current, true);
                   return true;
               }
           }
       }

       memo.put(current, false);
       return false;
    }

    public long countVariances() {
        long count = 0;
        for (String line : lines) {
            count += dpTally(line, new HashMap<>());
        }
        return count;
    }

    public long dpTally(String current, Map<String, Long> memo) {
        if (current.isEmpty()) {
            return 1;
        }
        if (memo.containsKey(current)) {
            return memo.get(current);
        }

        long res = 0;
        for (String towel : towels) {
            if (current.startsWith(towel)) {
                res += dpTally(current.substring(towel.length()), memo);
            }
        }

        memo.put(current, res);
        return res;
    }
}
