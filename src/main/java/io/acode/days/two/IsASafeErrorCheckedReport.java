package io.acode.days.two;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

public class IsASafeErrorCheckedReport implements Predicate<List<Integer>> {

    private final boolean error;

    public IsASafeErrorCheckedReport() {
        error = false;
    }

    public IsASafeErrorCheckedReport(boolean error) {
        this.error = error;
    }

    @Override
    public boolean test(List<Integer> integers) {
        int last = -1;
        Boolean positive = null;

        for (int i = 0; i < integers.size(); i++) {
            int next = integers.get(i);
            if (last != -1) {
                var diff = next - last;
                var abs = Math.abs(diff);
                if (abs < 1 || abs > 3) {
                    if (error) {
                        return false;
                    }
                    return retest(integers, i);
                }
                if (positive == null) {
                    positive = diff > 0;
                } else if (diff < 0 == positive) {
                    if (error) {
                        return false;
                    }
                    return retest(integers, i-1) || retest(integers, i);
                }
            }
            last = next;
        }
        return true;
    }

    private boolean retest(List<Integer> integers, int i) {
        IsASafeErrorCheckedReport errorCheck = new IsASafeErrorCheckedReport(true);

        var copy1 = new ArrayList<>(integers);
        copy1.remove(i - 1);
        var copy2 = new ArrayList<>(integers);
        copy2.remove(i);
        return errorCheck.test(copy1) || errorCheck.test(copy2);
    }
}
