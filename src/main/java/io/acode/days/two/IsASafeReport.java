package io.acode.days.two;

import java.util.List;
import java.util.function.Predicate;

public class IsASafeReport implements Predicate<List<Integer>> {

    @Override
    public boolean test(List<Integer> integers) {
        int last = -1;
        Boolean positive = null;

        for (int next : integers) {
            if (last != -1) {
                var diff = next - last;
                var abs = Math.abs(diff);
                if (abs < 1 || abs > 3) {
                    return false;
                }
                if (positive == null) {
                    positive = diff > 0;
                } else if (diff < 0 == positive) {

                    return false;
                }
            }
            last = next;
        }
        return true;
    }
}
