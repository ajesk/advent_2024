package io.acode.days.eleven;

import io.acode.util.FileReader;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PlutonianPebbles {
    List<Long> basePebbles;

    public PlutonianPebbles(String file) {
        basePebbles = FileReader.readFile(file).map(line -> List.of(line.split(" ")))
                .flatMap(List::stream)
                .map(Long::parseLong)
                .toList();
    }

    public long blinkAndCount(int blink) {
        int tally = 0;
        Map<String, Long> memo = new HashMap<>();
        return basePebbles.stream()
                .mapToLong(pebble -> blinkAndCount(blink, pebble, memo))
                .sum();
    }

    public long blinkAndCount(int blink, long rock, Map<String, Long> memo) {
        var key = blink + "-" + rock;
        if (blink == 0) {
            return 1;
        } else if (memo.containsKey(key)) {
            return memo.get(key);
        }

        if (rock == 0) {
            memo.put(key, blinkAndCount(blink - 1, rock + 1, memo));
        } else if (String.valueOf(rock).length() % 2 == 0) {
            var rockStr = String.valueOf(rock);
            var mid = rockStr.length() / 2;
            var rock1 = Long.parseLong(rockStr.substring(0, mid));
            var rock2 = Long.parseLong(rockStr.substring(mid));
            memo.put(key, blinkAndCount(blink - 1, rock1, memo) + blinkAndCount(blink - 1, rock2, memo));
        } else {
            memo.put(key, blinkAndCount(blink - 1, rock * 2024, memo));
        }
        return memo.get(key);
    }
}
