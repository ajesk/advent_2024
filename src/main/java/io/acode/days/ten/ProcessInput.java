package io.acode.days.ten;

import java.util.Arrays;
import java.util.List;
import java.util.function.Function;

public class ProcessInput implements Function<String, List<Integer>> {
    @Override
    public List<Integer> apply(String s) {
        return Arrays.stream(s.split(""))
                .map(Integer::parseInt)
                .toList();
    }
}
