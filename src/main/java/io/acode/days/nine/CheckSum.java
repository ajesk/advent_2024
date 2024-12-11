package io.acode.days.nine;

import java.util.List;
import java.util.function.ToLongFunction;

public class CheckSum implements ToLongFunction<List<Integer>> {

    @Override
    public long applyAsLong(List<Integer> defragmentedData) {
        long tally = 0;
        for (int i = 0; i < defragmentedData.size(); i++) {
            var currentNum = defragmentedData.get(i);
            if (currentNum != -1) {
                tally += (long) i * defragmentedData.get(i);
            }
        }

        return tally;
    }
}
